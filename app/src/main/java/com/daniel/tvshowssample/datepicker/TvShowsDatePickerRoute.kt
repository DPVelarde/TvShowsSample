package com.daniel.tvshowssample.datepicker

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.daniel.tvshowssample.schedule.TvShowsScheduleViewModel

@Composable
fun TvShowsDatePickerRoute(
    viewModel: TvShowsScheduleViewModel,
    navController: NavController
) {
    TvShowsDatePickerScreen(
        onBackPressed = {
            navController.navigateUp()
        },
        onDateConfirmed = {
            viewModel.updateSelectedDate(it)
            navController.navigateUp()
        },
        dateValidator = viewModel::dateValidator
    )
}