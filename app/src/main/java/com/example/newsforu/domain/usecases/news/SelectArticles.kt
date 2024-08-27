package com.example.newsforu.domain.usecases.news

import com.example.newsforu.data.local.NewsDao
import com.example.newsforu.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticles (
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>>{
        return newsDao.getArticles()
    }

}