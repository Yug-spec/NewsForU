package com.example.newsforu.presentation.bookmark

import com.example.newsforu.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)
