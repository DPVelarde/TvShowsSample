package com.daniel.tvshowssample.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.daniel.tvshowssample.datepicker.TvShowsDatePickerRoute
import com.daniel.tvshowssample.detail.TvShowDetailRoute
import com.daniel.tvshowssample.schedule.TvShowsScheduleRoute
import com.daniel.tvshowssample.search.TvShowsSearchRoute

private const val PARENT_ROUTE = "Parent"
private const val PARENT_DESTINATION = "ParentDestination"

private const val ID_ARG = "id"
private const val ID_ARG_DEFAULT = -1

@Composable
fun TvShowNavigationHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = PARENT_ROUTE) {
        navigation(
            startDestination = Screens.ShowsSchedule.route,
            route = PARENT_ROUTE
        ) {
            composable(
                route = Screens.ShowsSchedule.route
            ) {
                val parentEntry = remember(it) {
                    navController.getBackStackEntry(PARENT_ROUTE)
                }

                TvShowsScheduleRoute(
                    viewModel = hiltViewModel(parentEntry),
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
                    viewModel = hiltViewModel(),
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

            composable(
                route = Screens.ShowsDatePicker.route
            ) {
                val parentEntry = remember(it) {
                    navController.getBackStackEntry(PARENT_ROUTE)
                }

                TvShowsDatePickerRoute(
                    viewModel = hiltViewModel(parentEntry),
                    navController = navController
                )
            }
        }
    }
}