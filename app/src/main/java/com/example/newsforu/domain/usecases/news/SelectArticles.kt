package com.example.newsforu.domain.usecases.news

import com.example.newsforu.data.local.NewsDao
import com.example.newsforu.domain.model.Article
import com.example.newsforu.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles (
    private val newsRepository: NewsRepository
) {

    operator fun invoke(): Flow<List<Article>>{
        return newsRepository.selectArticles()
    }

}