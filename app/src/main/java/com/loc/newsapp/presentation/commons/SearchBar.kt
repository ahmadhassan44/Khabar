package com.loc.newsapp.presentation.commons

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.loc.newsapp.R
import com.loc.newsapp.presentation.Dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier,
    text:String,
    readOnly:Boolean,
    onCLick:(()->Unit)?,
    onValueChange:(String)->Unit,
    onSearch:()->Unit
) {

    val interactionSource= remember {
        MutableInteractionSource()
    }
    val isClicked=interactionSource.collectIsPressedAsState().value
    LaunchedEffect(isClicked) {
        if(isClicked) {
            onCLick?.invoke()
        }
    }
    TextField(
        modifier = modifier
            .searchBarBorder()
            .fillMaxWidth(),
        readOnly = readOnly,
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            textColor = if(isSystemInDarkTheme()) Color.White else Color.Red,
            containerColor = colorResource(R.color.input_background),
            focusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        leadingIcon = {
            Icon(painter = painterResource(R.drawable.ic_search), contentDescription = null, tint = colorResource(R.color.body))
        },
        value = text,
        onValueChange = onValueChange,
        placeholder = {
            Text("Search", style = MaterialTheme.typography.bodySmall, color = colorResource(R.color.placeholder))
        },
        shape = MaterialTheme.shapes.medium,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch={
                onSearch()
            }
        ),
        interactionSource = interactionSource,
        textStyle = MaterialTheme.typography.bodySmall
    )
}

fun Modifier.searchBarBorder() = composed { composed {
    if(!isSystemInDarkTheme())
        border(
            width = 1.dp,
            color = Color.Black,
            shape = MaterialTheme.shapes.medium
        )
    else
        this
} }
@Preview
@Composable
fun SearchBarPreview() {
    SearchBar(text = "", readOnly = true, onCLick = null, onValueChange = {}, onSearch = {}, modifier = Modifier)
}