package com.loc.newsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.loc.newsapp.data.remote.dto_responsetypes.NewsAPI
import com.loc.newsapp.data.remote.dto_responsetypes.NewsPagingSource
import com.loc.newsapp.domain.models.Article
import com.loc.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private  val newsAPI: NewsAPI
) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { NewsPagingSource(newsApi = newsAPI, sources=sources.joinToString(",")) }
        ).flow
    }
}