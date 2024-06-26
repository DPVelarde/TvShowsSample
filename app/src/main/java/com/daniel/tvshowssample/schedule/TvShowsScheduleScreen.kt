package com.daniel.tvshowssample.schedule

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.data.model.Show
import com.daniel.tvshowssample.R
import com.daniel.tvshowssample.ui.component.GenericErrorScreen
import com.daniel.tvshowssample.ui.component.LoadingScreen
import com.daniel.tvshowssample.ui.theme.TvShowsSampleTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TvShowsScheduleScreen(
    state: TvShowsScheduleViewState,
    onShowClicked: (Show) -> Unit = {},
    onSearchClicked: () -> Unit = {},
    onDatePickerClicked: () -> Unit = {},
    onReload: () -> Unit = {}
) {
    val listState = rememberLazyListState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.shows_schedule_title))
                },
                actions = {
                    IconButton(onClick = onDatePickerClicked) {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = stringResource(id = R.string.date_picker_action)
                        )
                    }
                    IconButton(onClick = onSearchClicked) {
                        Icon(
                            imageVector = Icons.Default.Search,
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
                (state.showsSchedule != null) -> {
                    TvShowsScheduleScreenContent(
                        listState = listState,
                        state = state,
                        onShowClicked = onShowClicked
                    )
                }

                (state.error != null) -> {
                    GenericErrorScreen(
                        button = stringResource(id = R.string.retry),
                        onButtonClicked = onReload
                    )
                }

                else -> {
                    LoadingScreen()
                }
            }
        }
    }

    LaunchedEffect(state.selectedDate) {
        listState.scrollToItem(0)
    }
}

@Preview(showBackground = true)
@Composable
internal fun TvShowsScheduleScreenPreview() {
    TvShowsSampleTheme {
        TvShowsScheduleScreen(state = TvShowsScheduleViewState(isLoading = true))
    }
}