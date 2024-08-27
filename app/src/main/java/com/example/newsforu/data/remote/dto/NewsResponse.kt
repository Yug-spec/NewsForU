package com.example.newsforu.data.remote.dto

import com.example.newsforu.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)