package com.loc.newsapp.presentation.commons

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.loc.newsapp.R
import com.loc.newsapp.domain.models.Article
import com.loc.newsapp.domain.models.Source
import com.loc.newsapp.ui.theme.NewsAppTheme

@Composable
fun ArticleCard(
    modifier: Modifier,
    article: Article,
    onClick: () -> Unit
) {
    Row(
        Modifier.clickable { onClick() }
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(article.urlToImage).build(),
            null,
            Modifier.size(96.dp).clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop
        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .height(96.dp)
        ) {
            Text(
                text = article.title,
                modifier=Modifier.padding(10.dp),
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(R.color.text_title),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(horizontal = 10.dp)
                    .padding(bottom = 4.dp)
            ) {
                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.labelSmall,
                    color = colorResource(R.color.display_small),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier.width(60.dp))
                Icon(painter = painterResource(R.drawable.ic_time), contentDescription = null,
                    tint = colorResource(R.color.body)
                )
                Spacer(modifier.width(4.dp))
                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.labelSmall,
                    color = colorResource(R.color.display_small),
                    fontWeight = FontWeight.Bold
                )
            }


        }

    }
}
@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ArticleCardPreview() {
    NewsAppTheme(dynamicColor = false) {
        ArticleCard(
            article = Article(
                author = "",
                content = "",
                description = "",
                publishedAt = "2024-06-01T11:12:24Z",
                source = Source(id = "", name = "BBC"),
                title = "Her train broke down. Her phone died. And then she met her Saver in a",
                url = "",
                urlToImage = "https://ichef.bbci.co.uk/live-experience/cps/624/cpsprodpb/11787/production/_124395517_bbcbreakingnewsgraphic.jpg"
            ),
            modifier = Modifier,
            onClick = {}
        )
    }
}