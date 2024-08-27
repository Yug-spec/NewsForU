package com.example.newsforu.domain.usecases.news

import com.example.newsforu.data.local.NewsDao
import com.example.newsforu.domain.model.Article

class UpsertArticle(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article){
        newsDao.upsert(article)
    }

}