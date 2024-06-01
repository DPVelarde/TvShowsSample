package com.daniel.tvshowssample.schedule

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.tvshowssample.ui.component.GenericErrorScreen
import com.daniel.tvshowssample.ui.component.LoadingScreen
import com.daniel.tvshowssample.ui.theme.TvShowsSampleTheme

@Composable
fun TvShowsScheduleScreen(
    state: TvShowsScheduleViewState
) {
    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            when (true) {
                (state.showsSchedule != null) -> {
                    TvShowsScheduleScreenContent(state.showsSchedule)
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

@Preview
@Composable
internal fun TvShowsScheduleScreenPreview() {
    TvShowsSampleTheme {
        TvShowsScheduleScreen(state = TvShowsScheduleViewState(isLoading = true))
    }
}