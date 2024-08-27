package com.example.newsforu.presentation.onboarding

sealed class OnBoardingEvent {

    data object SaveAppEntry: OnBoardingEvent()

}