package com.loc.newsapp.presentation.commons

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.loc.newsapp.R
import com.loc.newsapp.domain.models.Article
import com.loc.newsapp.presentation.Dimens

@OptIn(ExperimentalFoundationApi::class, ExperimentalSharedTransitionApi::class)
@Composable
fun ArticlesList(
    modifier: Modifier,
    articles:LazyPagingItems<Article>,
    onClick:(Article)->Unit
) {
    Spacer(modifier = Modifier.height(Dimens.ExtraSmallPadding2))
    if(handlePagingResult(articles)) {
        val titles by remember {
            derivedStateOf {
                if (articles.itemCount > 10) {
                    articles.itemSnapshotList.items
                        .slice(IntRange(start = 0, endInclusive = 9))
                        .joinToString(separator = " \uD83D\uDFE5 ") { it.title }
                } else {
                    ""
                }
            }
        }
        Text(
            text = titles, modifier = Modifier
                .fillMaxWidth()
                .padding(start = Dimens.MediumPadding1)
                .basicMarquee(), fontSize = 12.sp,
            color = colorResource(id = R.color.placeholder)
        )
        Spacer(Modifier.height(Dimens.ExtraSmallPadding2))
        LazyColumn(
            modifier=Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(Dimens.MediumPadding1),
            contentPadding = PaddingValues(all = Dimens.ExtraSmallPadding2)
        ) {
            items(articles.itemCount) { index ->
                articles[index]?.let {
                    ArticleCard(
                        article = it,
                        onClick = { onClick(it) },
                        modifier = Modifier,
                    )
                }
            }
        }
    }

}
@Composable
fun handlePagingResult(
    articles:LazyPagingItems<Article>
):Boolean {
    val loadState = articles.loadState
    val error= when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }
    return when {
        loadState.refresh is LoadState.Loading -> {
            shimmerEffect()
            false
        }
        error != null -> {
            EmptyScreen(error)
            false
        }
        articles.itemCount==0->{
            EmptyScreen(LoadState.Error(error=Throwable()))
            false
        }
        else -> {
            true 
        }
    }
}
@Composable
fun shimmerEffect() {
    Column(verticalArrangement = Arrangement.spacedBy(Dimens.MediumPadding1)) {
        repeat(10){
            ArticleCardShimmerEffect(
                modifier = Modifier
            )
        }
    }
}