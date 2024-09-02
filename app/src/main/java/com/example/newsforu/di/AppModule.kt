package com.example.newsforu.di

import android.app.Application
import com.example.newsforu.data.manager.LocalUserManagerImpl
import com.example.newsforu.data.remote.dto.NewsApi
import com.example.newsforu.data.repository.NewsRepositoryImpl
import com.example.newsforu.domain.manager.LocalUserManager
import com.example.newsforu.domain.repository.NewsRepository
import com.example.newsforu.domain.usecases.app_entry.AppEntryUseCases
import com.example.newsforu.domain.usecases.app_entry.ReadAppEntry
import com.example.newsforu.domain.usecases.app_entry.SaveAppEntry
import com.example.newsforu.domain.usecases.news.GetNews
import com.example.newsforu.domain.usecases.news.NewsUseCases
import com.example.newsforu.util.Constants.BASE_URL
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
        newsRepository: NewsRepository
    ): NewsUseCases{
        return NewsUseCases(
            getNews = GetNews(newsRepository)
        )
    }


}