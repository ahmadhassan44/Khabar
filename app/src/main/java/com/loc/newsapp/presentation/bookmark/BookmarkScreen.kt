package com.loc.newsapp.presentation.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.loc.newsapp.R
import com.loc.newsapp.domain.models.Article
import com.loc.newsapp.presentation.Dimens
import com.loc.newsapp.presentation.commons.SearchedArticlesList
import com.loc.newsapp.presentation.navgraph.Route

@Composable
fun BookmarkScreen(
    state:BookmarkState,
    navigateToDetails:(Article)->Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(top=Dimens.MediumPadding1, start = Dimens.MediumPadding1, end = Dimens.MediumPadding1)
    ) {
        Text(
            text = "Bookmarks",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start),
            style = MaterialTheme.typography.headlineLarge,
            color=colorResource(id = R.color.text_title)
        )
        SearchedArticlesList(state.articles.reversed(), onClick = navigateToDetails)
    }

}