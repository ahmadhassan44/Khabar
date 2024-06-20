package com.loc.newsapp.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.loc.newsapp.presentation.Dimens
import com.loc.newsapp.presentation.commons.ArticlesList
import com.loc.newsapp.presentation.commons.SearchBar
import com.loc.newsapp.presentation.commons.SearchedArticlesList

@Composable
fun SearchScreen(
    state: SearchState,
    event: (SearchEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(top = 18.dp, start = Dimens.ExtraSmallPadding, end = Dimens.ExtraSmallPadding)
    ) {
        SearchBar(
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding1),
            text = state.searchQuery,
            readOnly = false,
            onCLick = {},
            onValueChange = {arg->
                event(SearchEvent.UpdateSearchQuery(arg))
                event(SearchEvent.SearchNews)
                            },
            onSearch = { event(SearchEvent.SearchNews) },
        )
        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))
        state.searchResults?.collectAsLazyPagingItems()?.let {
            SearchedArticlesList(it) {

            }
        }
    }
}