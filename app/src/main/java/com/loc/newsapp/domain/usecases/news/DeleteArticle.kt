package com.loc.newsapp.domain.usecases.news

import com.loc.newsapp.data.local.ArticleDAO
import com.loc.newsapp.domain.models.Article

class DeleteArticle(
    private val articleDAO: ArticleDAO
) {
    suspend operator fun invoke(article: Article) = articleDAO.delete(article)
}