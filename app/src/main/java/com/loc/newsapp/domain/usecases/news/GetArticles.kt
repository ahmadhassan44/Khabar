package com.loc.newsapp.domain.usecases.news

import com.loc.newsapp.data.local.ArticleDAO
import com.loc.newsapp.domain.models.Article
import kotlinx.coroutines.flow.Flow

class GetArticles(
    private val articleDAO: ArticleDAO
) {
    operator fun invoke(): Flow<List<Article>> {
        return articleDAO.getArticles()
    }
}