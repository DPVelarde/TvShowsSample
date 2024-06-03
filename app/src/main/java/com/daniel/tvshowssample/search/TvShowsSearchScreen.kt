package com.daniel.tvshowssample.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.data.model.Show
import com.daniel.tvshowssample.R
import com.daniel.tvshowssample.ui.component.GenericErrorScreen
import com.daniel.tvshowssample.ui.component.InformationScreen
import com.daniel.tvshowssample.ui.component.LoadingScreen
import com.daniel.tvshowssample.ui.theme.TvShowsSampleTheme
import kotlinx.coroutines.delay

private const val INPUT_DEBOUNCE_TIME = 2000L

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TvShowsSearchScreen(
    state: TvShowsSearchViewState,
    onShowClicked: (Show) -> Unit = {},
    onShowSearch: (String) -> Unit = {},
    onBackPressed: () -> Unit = {}
) {
    var queryText by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.shows_search_title))
                },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { it ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = queryText,
                    onValueChange = { value ->
                        queryText = value
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null)
                    },
                    singleLine = true,
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            onShowSearch(queryText.text)
                        }
                    ),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search)
                )
                when (true) {
                    (state.shows != null) -> {
                        if (state.shows.isNotEmpty()) {
                            TvShowsSearchScreenContent(
                                items = state.shows,
                                onShowClicked = onShowClicked
                            )
                        } else {
                            InformationScreen(
                                image = R.drawable.il_not_found,
                                text = stringResource(id = R.string.shows_search_not_found)
                            )
                        }
                    }

                    (state.error != null) -> {
                        GenericErrorScreen()
                    }

                    (state.isLoading) -> {
                        LoadingScreen()
                    }

                    else -> {
                        InformationScreen(
                            image = R.drawable.il_search_image,
                            text = stringResource(id = R.string.shows_search_placeholder)
                        )
                    }
                }
            }
        }
    }

    LaunchedEffect(key1 = queryText) {
        if (queryText.text.isBlank()) return@LaunchedEffect

        delay(INPUT_DEBOUNCE_TIME)
        onShowSearch(queryText.text)
    }
}

@Preview
@Composable
internal fun TvShowsSearchScreenPreview() {
    TvShowsSampleTheme {
        TvShowsSearchScreen(state = TvShowsSearchViewState())
    }
}