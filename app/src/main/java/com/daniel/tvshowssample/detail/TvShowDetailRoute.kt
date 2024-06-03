package com.daniel.tvshowssample.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun TvShowDetailRoute(
    viewModel: TvShowDetailViewModel = hiltViewModel(),
    navController: NavController,
    id: Int
) {
    TvShowDetailScreen(
        state = viewModel.state.value,
        onBackPressed = {
            navController.navigateUp()
        }
    )

    LaunchedEffect(Unit) {
        viewModel.getTvShowDetail(id)
    }
}