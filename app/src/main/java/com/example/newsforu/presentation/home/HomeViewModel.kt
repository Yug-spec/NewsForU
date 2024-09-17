package com.example.newsforu.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newsforu.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
): ViewModel() {

    val news = newsUseCases.getNews(
        sources = listOf("bbc-news","abc-news","al-jazeera-english","ansa","australian-financial-review","bbc-sport","cbc-news",
            "crypto-coins-news","entertainment-weekly","espn","espn-cric-info","google-news","google-news-in")
    ).cachedIn(viewModelScope)

}