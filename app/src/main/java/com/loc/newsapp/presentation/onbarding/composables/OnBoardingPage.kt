package com.loc.newsapp.presentation.onbarding.composables

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.loc.newsapp.R
import com.loc.newsapp.presentation.Dimens
import com.loc.newsapp.presentation.onbarding.Page
import com.loc.newsapp.presentation.onbarding.onboardingPages

@Composable
fun OnBoardingPage(page: Page) {
    Column {
        Image(
            painter = painterResource(page.picture),
            null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.60f),
            contentScale = ContentScale.Crop
        )
        Spacer(
            modifier = Modifier.height(Dimens.MediumPadding1)
        )
        Column(
        ) {
            Text(
                text = page.title,
                fontWeight = FontWeight.ExtraBold,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(horizontal = Dimens.MediumPadding2),
                color = colorResource(R.color.display_small),
                fontSize = 28.sp
            )
            Spacer(
                modifier = Modifier.height(Dimens.MediumPadding1)
            )
            Text(
                text = page.desc,
                fontWeight = FontWeight.Thin,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = Dimens.MediumPadding2),
                color = colorResource(R.color.display_small),
            )
        }

    }
}
@Preview(showSystemUi = true, showBackground = true)
@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable()
fun OnBoardingPagePreview1() {
    OnBoardingPage(page = onboardingPages[0])
}