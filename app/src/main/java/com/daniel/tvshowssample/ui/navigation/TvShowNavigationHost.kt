package com.daniel.tvshowssample.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.daniel.tvshowssample.detail.TvShowDetailRoute
import com.daniel.tvshowssample.schedule.TvShowsScheduleRoute

@Composable
fun TvShowNavigationHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screens.ShowsSchedule.route) {
        composable(
            route = Screens.ShowsSchedule.route
        ) {
            TvShowsScheduleRoute(
                viewModel = hiltViewModel(),
                navController = navController
            )
        }

        composable(
            route = Screens.ShowDetail.route,
            arguments = listOf(
                navArgument(name = "id") { type = NavType.IntType }
            )
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getInt("id") ?: -1
            TvShowDetailRoute(
                navController = navController,
                id = id
            )
        }
    }
}