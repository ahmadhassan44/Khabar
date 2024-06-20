package com.loc.newsapp.presentation.details.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.loc.newsapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsTopBar(
    onBookmarkClick:()->Unit,
    onShareClick:()->Unit,
    onBrowsingClick:()->Unit,
    onBackClick:()->Unit,
) {
    TopAppBar(
        title = {},
        modifier = Modifier
            .fillMaxWidth(),
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Transparent,
            actionIconContentColor = colorResource(R.color.body),
            navigationIconContentColor = colorResource(R.color.body)
        ),
        navigationIcon = {
            IconButton(
                onClick = onBackClick,

            ) {
                Icon(
                    painterResource(R.drawable.ic_back_arrow),
                    null
                )
            }
        },
        actions = {
            IconButton(
                onClick = onBookmarkClick,

                ) {
                Icon(
                    painterResource(R.drawable.ic_bookmark),
                    null
                )
            }
            IconButton(
                onClick = onShareClick,

                ) {
                Icon(
                    Icons.Default.Share,
                    null
                )
            }
            IconButton(
                onClick = onBrowsingClick,
                ) {
                Icon(
                    painterResource(R.drawable.ic_network),
                    null
                )
            }
        }

    )
}