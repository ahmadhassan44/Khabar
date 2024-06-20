package com.loc.newsapp.presentation.bookmark

import com.loc.newsapp.domain.models.Article
import com.loc.newsapp.domain.usecases.news.GetArticles

data class BookmarkState (
    val articles: List<Article> = emptyList()
)