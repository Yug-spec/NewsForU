package com.example.newsforu.domain.repository

import androidx.paging.PagingData
import com.example.newsforu.domain.model.Article
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

interface NewsRepository {

    fun getNews(sources : List<String>): Flow<PagingData<Article>>

    fun searchNews(searchQuery: String,sources : List<String>): Flow<PagingData<Article>>

}