package com.example.newsforu.domain.usecases.news

import androidx.paging.PagingData
import com.example.newsforu.domain.model.Article
import com.example.newsforu.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(sources: List<String>):Flow<PagingData<Article>>{
        return newsRepository.getNews(sources = sources)
    }

}