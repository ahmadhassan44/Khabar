package com.loc.newsapp.presentation.onbarding.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.loc.newsapp.presentation.commons.NewsButton
import com.loc.newsapp.presentation.commons.NewsTextButton
import com.loc.newsapp.presentation.Dimens
import com.loc.newsapp.presentation.onbarding.events.OnBoardingEvent
import com.loc.newsapp.presentation.onbarding.onboardingPages
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    event:(OnBoardingEvent)->Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val pagerState= rememberPagerState(initialPage = 0) {
            onboardingPages.size
        }
        val buttonState=remember {
            derivedStateOf {
                when(pagerState.currentPage) {
                    0->listOf("Next")
                    1-> listOf("Next","Back")
                    2-> listOf("Get Started","Back")
                    else -> listOf("")
                }
            }
        }
        HorizontalPager(state = pagerState) {index->
            OnBoardingPage(onboardingPages[index])
        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.MediumPadding1)
            .navigationBarsPadding()
            .weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Row(verticalAlignment = Alignment.CenterVertically) {
                Indicator(
                    pageSize = onboardingPages.size,
                    selectedPage = pagerState.currentPage
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement =
            Arrangement.SpaceBetween) {
                val scope= rememberCoroutineScope()
                if(pagerState.currentPage!=0) {
                    NewsTextButton(buttonState.value[1]) {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    }
                }
                Spacer(modifier = Modifier.width(16.dp))
                NewsButton(
                    text = buttonState.value[0],
                ) {
                    scope.launch {
                        if (pagerState.currentPage == 2) {
                            event(OnBoardingEvent.saveAppEntry)
                        } else
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }
            }

        }
    }
}