package com.loc.newsapp.presentation.search

import androidx.paging.PagingData
import com.loc.newsapp.domain.models.Article
import kotlinx.coroutines.flow.Flow

data class SearchState (
    val searchQuery: String = "",
    val searchResults: Flow<PagingData<Article>>? =null
)