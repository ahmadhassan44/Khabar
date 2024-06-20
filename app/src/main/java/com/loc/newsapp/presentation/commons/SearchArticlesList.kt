package com.loc.newsapp.presentation.commons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import com.loc.newsapp.domain.models.Article
import com.loc.newsapp.presentation.Dimens

@Composable
fun SearchedArticlesList(
    articles:LazyPagingItems<Article>,
    onClick:()->Unit
) {
    Spacer(modifier = Modifier.height(Dimens.ExtraSmallPadding2))
    if(handlePagingResult(articles)) {
        LazyColumn(
            modifier=Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(Dimens.MediumPadding1),
            contentPadding = PaddingValues(all = Dimens.ExtraSmallPadding2)
        ) {
            items(articles.itemCount) { index ->
                articles[index]?.let {
                    ArticleCard(
                        article = it,
                        onClick = onClick,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}
@Composable
fun SearchedArticlesList(
    articles:List<Article>,
    onClick:()->Unit
) {
    Spacer(modifier = Modifier.height(Dimens.ExtraSmallPadding2))
    LazyColumn(
        modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(Dimens.MediumPadding1),
        contentPadding = PaddingValues(all = Dimens.ExtraSmallPadding2)
    ) {
        items(articles.size) { index ->
            articles[index]?.let {
                ArticleCard(
                    article = it,
                    onClick = onClick,
                    modifier = Modifier
                )
            }
        }
    }
}
