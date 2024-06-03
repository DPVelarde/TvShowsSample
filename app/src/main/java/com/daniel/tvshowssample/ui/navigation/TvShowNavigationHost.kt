package com.daniel.tvshowssample.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.daniel.tvshowssample.detail.TvShowDetailRoute
import com.daniel.tvshowssample.schedule.TvShowsScheduleRoute
import com.daniel.tvshowssample.search.TvShowsSearchRoute

private const val ID_ARG = "id"
private const val ID_ARG_DEFAULT = -1

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
                navArgument(name = ID_ARG) { type = NavType.IntType }
            )
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getInt(ID_ARG) ?: ID_ARG_DEFAULT
            TvShowDetailRoute(
                navController = navController,
                id = id
            )
        }

        composable(
            route = Screens.ShowSearch.route
        ) {
            TvShowsSearchRoute(
                viewModel = hiltViewModel(),
                navController = navController
            )
        }
    }
}