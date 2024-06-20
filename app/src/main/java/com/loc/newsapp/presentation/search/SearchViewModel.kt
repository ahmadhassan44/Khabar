package com.loc.newsapp.presentation.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.loc.newsapp.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
):ViewModel() {

    private val state= mutableStateOf(SearchState())
    var searchState=state
        private set

    fun onEvent(event: SearchEvent){
        when {
            event is SearchEvent.UpdateSearchQuery -> {
                state.value=searchState.value.copy(event.searchQuery)
            }
            event is SearchEvent.SearchNews -> {
                val articles = newsUseCases.searchNews(
                    searchQuery = state.value.searchQuery,
                    sources = listOf("bbc-news", "abc-news", "al-jazeera-english")
                ).cachedIn(viewModelScope)
                state.value = state.value.copy(searchResults = articles)
            }
        }
    }
}