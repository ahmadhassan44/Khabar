package com.loc.newsapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.newsapp.domain.usecases.appEntry.AppEntryUseCases
import com.loc.newsapp.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
     appEntryUseCases: AppEntryUseCases
) :ViewModel() {

    var splashCondition=mutableStateOf(true)
        private set
    var startdestination by mutableStateOf(Route.AppStartNavigation.route)
        private set

    init{
        appEntryUseCases.readAppEntry().onEach {
            if(it)
                startdestination=Route.NewsNavigation.route
            else
                startdestination=Route.AppStartNavigation.route
            delay(300)
            splashCondition.value=false
        }.launchIn(viewModelScope)
    }
}