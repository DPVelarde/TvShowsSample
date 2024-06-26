package com.daniel.tvshowssample.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.tvshowssample.R
import com.daniel.tvshowssample.ui.component.GenericErrorScreen
import com.daniel.tvshowssample.ui.component.LoadingScreen
import com.daniel.tvshowssample.ui.theme.TvShowsSampleTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TvShowDetailScreen(
    state: TvShowDetailViewState,
    onBackPressed: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.show_detail_title))
                },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(id = R.string.navigate_up)
                        )
                    }
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            when (true) {
                (state.show != null) -> {
                    TvShowDetailScreenContent(state.show)
                }

                (state.error != null) -> {
                    GenericErrorScreen()
                }

                else -> {
                    LoadingScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun TvShowDetailScreenPreview() {
    TvShowsSampleTheme {
        TvShowDetailScreen(state = TvShowDetailViewState(isLoading = true))
    }
}