package com.example.newsforu.di

import android.app.Application
import androidx.room.Room
import com.example.newsforu.data.local.NewsDao
import com.example.newsforu.data.local.NewsDatabase
import com.example.newsforu.data.local.NewsTypeConvertor
import com.example.newsforu.data.manager.LocalUserManagerImpl
import com.example.newsforu.data.remote.dto.NewsApi
import com.example.newsforu.data.repository.NewsRepositoryImpl
import com.example.newsforu.domain.manager.LocalUserManager
import com.example.newsforu.domain.repository.NewsRepository
import com.example.newsforu.domain.usecases.app_entry.AppEntryUseCases
import com.example.newsforu.domain.usecases.app_entry.ReadAppEntry
import com.example.newsforu.domain.usecases.app_entry.SaveAppEntry
import com.example.newsforu.domain.usecases.news.DeleteArticle
import com.example.newsforu.domain.usecases.news.GetNews
import com.example.newsforu.domain.usecases.news.NewsUseCases
import com.example.newsforu.domain.usecases.news.SearchNews
import com.example.newsforu.domain.usecases.news.SelectArticle
import com.example.newsforu.domain.usecases.news.SelectArticles
import com.example.newsforu.domain.usecases.news.UpsertArticle
import com.example.newsforu.util.Constants.BASE_URL
import com.example.newsforu.util.Constants.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )


    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)


    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCases{
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
             upsertArticle = UpsertArticle(newsDao),
            deleteArticle = DeleteArticle(newsDao),
            selectArticles = SelectArticles(newsDao),
            selectArticle = SelectArticle(newsDao)

        )
    }

    @Provides
    @Singleton
    fun provideNewsdatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsdao(
        newsDatabase: NewsDatabase
    ):NewsDao = newsDatabase.newsDao


}