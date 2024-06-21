package com.loc.newsapp.presentation.newsNavigator.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.loc.newsapp.R
import com.loc.newsapp.presentation.Dimens

@Composable
fun BottomNav(
    items:List<BottomNavigationItem>,
    selected:Int,
    onItemCLick:(Int)->Unit
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.background,
        tonalElevation = 10.dp
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected=index==selected,
                onClick = { onItemCLick(index) },
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(item.img),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.height(Dimens.ExtraSmallPadding))
                        Text(
                            text = item.title,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = colorResource(R.color.body),
                    unselectedTextColor = colorResource(R.color.body),
                    indicatorColor = MaterialTheme.colorScheme.background
                )
            )
        }
    }
}

data class BottomNavigationItem(
    @DrawableRes val img:Int,
    val title:String
)
@Preview
@Composable
fun BottomNavPreview(){
    BottomNav(
        listOf(
            BottomNavigationItem(img = R.drawable.ic_home, title = "Home"),
            BottomNavigationItem(img = R.drawable.ic_search, title = "Search"),
            BottomNavigationItem(img = R.drawable.ic_bookmark, title = "Bookmark"),
        ),
        onItemCLick = {},
        selected = 2
    )
}