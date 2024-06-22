package com.loc.newsapp.presentation.onbarding

import androidx.annotation.DrawableRes
import com.loc.newsapp.R

data class Page(
    val title:String,
    val desc:String,
    @DrawableRes val picture:Int
)
val onboardingPages = listOf(
    Page(
        title = "Stay Informed, Stay Connected",
        desc = "Welcome to Khabar, your go-to app for the latest news updates and stories from around the world.",
        picture = R.drawable.onboarding1
    ),
    Page(
        title = "Tailored According to Your Interests",
        desc = "Welcome to Khabar, your go-to app for the latest news updates and stories from around the world.",
        picture = R.drawable.onboarding2
    ),
    Page(
        title = "Instant Alerts and Updates",
        desc = "Welcome to Khabar, your go-to app for the latest news updates and stories from around the world.",
        picture = R.drawable.onboarding3
    )
)
