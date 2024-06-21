package com.loc.newsapp.presentation.details.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.newsapp.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
):ViewModel() {
    var sideEffect by mutableStateOf<String?>(null)
        private set

    fun onEvent(event: DetailEvents) {
        when {
            event is DetailEvents.UpsertDeleteArticle -> {
                viewModelScope.launch {
                    val article= event.article.url?.let { newsUseCases.getArticleByUrl(it) }
                    if(article==null) {
                        newsUseCases.upsertArticle(event.article)
                        sideEffect="Article Saved"
                    }
                    else {
                        newsUseCases.deleteArticle(event.article)
                        sideEffect="Article Removed"
                    }
                }
            }
            event is DetailEvents.RemoveSideEffect -> {
                sideEffect=null
            }
        }
    }
}