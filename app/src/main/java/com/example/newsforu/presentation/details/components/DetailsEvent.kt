package com.example.newsforu.presentation.details.components

import com.example.newsforu.domain.model.Article

sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article: Article): DetailsEvent()

    object RemoveSideEffect : DetailsEvent()

}