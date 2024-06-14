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
        desc = "Welcome to NewsFlash, your go-to app for the latest news updates and stories from around the world. Stay informed with breaking news, trending topics, and in-depth analysis, all at your fingertips",
        picture = R.drawable.onboarding1
    ),
    Page(
        title = "Tailored According to Your Interests",
        desc = "Discover news that matters to you. Customize your feed to get updates on your favorite topics, from politics and technology to entertainment and sports.Some dummy text",
        picture = R.drawable.onboarding2
    ),
    Page(
        title = "Instant Alerts and Updates",
        desc = "Stay ahead of the curve with real-time notifications. Get instant alerts on breaking news and important events as they happen. With NewsFlash, you're always in the know, no matter where you are.",
        picture = R.drawable.onboarding3
    )
)
