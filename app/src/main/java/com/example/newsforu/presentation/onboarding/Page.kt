package com.example.newsforu.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.newsforu.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "\"Stay Informed, Stay Ahead\"\n",
        description = "Get the latest news and updates from around the world, tailored to your interests. Personalize your feed and stay up-to-date on the topics that matter most to you",
        image = R.drawable.onboarding1
    ),

    Page(
            title = "\"Your News, Your Way\"\n",
    description = "Customize your feed with topics, sources, and locations that interest you. Get the news that matters most to you, in one convenient place",
    image = R.drawable.onboarding2

    ),

    Page(
        title = "\"Read, Relax, Repeat\"\n",
        description = "Enjoy your personalized news feed in a comfortable reading experience, with easy-to-read fonts and adjustable text sizes. Plus, switch to Dark Mode to reduce eye strain and save battery life.",
        image = R.drawable.onboarding3

    )



)