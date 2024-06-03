package com.daniel.tvshowssample.schedule

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.daniel.tvshowssample.ui.navigation.Screens

@Composable
fun TvShowsScheduleRoute(
    viewModel: TvShowsScheduleViewModel,
    navController: NavController
) {
    TvShowsScheduleScreen(
        state = viewModel.state.value,
        onShowClicked = {
            navController.navigate("detail/${it.id}")
        },
        onSearchClicked = {
            navController.navigate(Screens.ShowSearch.route)
        },
        onDatePickerClicked = {
            navController.navigate(Screens.ShowsDatePicker.route)
        },
        onReload = {
            viewModel.reload()
        }
    )
}