package com.example.newsforu.presentation.search

import androidx.paging.PagingData
import com.example.newsforu.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery:String = "",
    val articles: Flow<PagingData<Article>>?= null
) {
}