package com.loc.newsapp.presentation.onbarding.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.newsapp.di.AppEntryUseCases
import com.loc.newsapp.presentation.onbarding.events.OnBoardingEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoradingViewModel @Inject constructor(
    val appEntryUseCases: AppEntryUseCases
):ViewModel() {
    fun onEvent (event: OnBoardingEvent) {
        when(event) {
            is OnBoardingEvent.saveAppEntry -> {
                viewModelScope.launch {
                     appEntryUseCases.saveAppEntry()
                }
            }
        }
    }

}