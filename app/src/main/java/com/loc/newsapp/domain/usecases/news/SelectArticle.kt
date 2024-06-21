package com.loc.newsapp.domain.usecases.news

import com.loc.newsapp.data.local.ArticleDAO
import com.loc.newsapp.domain.models.Article

class SelectArticle(
    private val articleDAO: ArticleDAO
) {
    suspend operator fun invoke(url: String):Article? {
        return articleDAO.getArticleByUrl(url)
    }
}