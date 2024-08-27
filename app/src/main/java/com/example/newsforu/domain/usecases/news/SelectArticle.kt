package com.example.newsforu.domain.usecases.news

import com.example.newsforu.data.local.NewsDao
import com.example.newsforu.domain.model.Article

class SelectArticle (
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(url: String): Article?{
        return newsDao.getArticle(url)
    }

}