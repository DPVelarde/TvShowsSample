package com.daniel.tvshowssample.search

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun TvShowsSearchRoute(
    viewModel: TvShowsSearchViewModel,
    navController: NavController
) {
    TvShowsSearchScreen(
        state = viewModel.state.value,
        onShowClicked = {
            navController.navigate("detail/${it.id}")
        },
        onShowSearch = {
            viewModel.searchTvShows(it)
        },
        onBackPressed = {
            navController.navigateUp()
        }
    )
}