package com.loc.newsapp.presentation.onbarding.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.loc.newsapp.ui.theme.BlueGray

@Composable
fun Indicator(
    modifier: Modifier=Modifier,
    pageSize:Int,
    selectedPage:Int,
    selectedPageColor:Color=MaterialTheme.colorScheme.primary,
    unselectedPage:Color= BlueGray
)
{
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.width(52.dp)) {
        repeat(pageSize) {page ->
            Box(
                modifier = modifier
                    .size(14.dp)
                    .clip(CircleShape)
                    .background(
                        color= if(page==selectedPage) selectedPageColor else unselectedPage
                    )
            )
        }

    }
}
@Preview(showSystemUi = true)
@Composable
fun IndicatorPreview()
{
    Indicator(modifier = Modifier, pageSize = 3, selectedPage = 2)
}