package com.loc.newsapp.data.remote.dto_responsetypes

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.loc.newsapp.domain.models.Article

class SearchNewsPagingSource(
    private val newsApi: NewsAPI,
    private val searchQuery: String,
    private val sources:String
) : PagingSource<Int, Article>() {
    private var totalNews:Int=0
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val page=params.key?:1
            val response=newsApi.searchNews(searchQuery,page,sources)
            totalNews+=response.articles.size
            val articles=response.articles.distinctBy {
                it.title
            }
            LoadResult.Page(
                data = articles,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (totalNews >= response.totalResults) null else page + 1
            )
        } catch(e:Exception) {
            LoadResult.Error(e)
        }
    }

}