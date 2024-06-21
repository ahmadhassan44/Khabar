package com.loc.newsapp.presentation.home

import android.widget.Space
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import coil.size.Dimension
import com.loc.newsapp.R
import com.loc.newsapp.domain.models.Article
import com.loc.newsapp.presentation.Dimens
import com.loc.newsapp.presentation.commons.ArticlesList
import com.loc.newsapp.presentation.commons.SearchBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    articles: LazyPagingItems<Article>,
    navigateToSearch: () -> Unit,
    navigateToDetails: (Article) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = Dimens.MediumPadding1)
            .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(75.dp)
                .padding(horizontal = Dimens.MediumPadding1)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(Dimens.ExtraSmallPadding2))
        SearchBar(
            text = "",
            readOnly = true,
            onValueChange = {},
            onCLick = {
                      navigateToSearch()
            },
            onSearch = {},
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding1)
        )
        Spacer(modifier = Modifier.height(Dimens.ExtraSmallPadding2))
        ArticlesList(modifier = Modifier, articles = articles) {
            navigateToDetails(it)
        }
    }

}