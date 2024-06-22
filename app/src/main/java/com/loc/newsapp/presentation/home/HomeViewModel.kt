package com.loc.newsapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.compose.collectAsLazyPagingItems
import com.loc.newsapp.domain.models.Article
import com.loc.newsapp.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private  val newsUseCases: NewsUseCases
):ViewModel() {
    var news: Flow<PagingData<Article>>?=null
//    fun getNews() = newsUseCases.getNews(
//        sources = listOf("bbc-news","abc-news","al-jazeera-english")
//    ).cachedIn(viewModelScope)

    fun getnews() : Flow<PagingData<Article>>? {
        if (news == null) {
            news = newsUseCases.getNews(
                sources = listOf("bbc-news","abc-news","al-jazeera-english")
            ).cachedIn(viewModelScope)
        }
        return news
    }
}