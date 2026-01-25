package com.patidost.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.patidost.app.feature.auth.AuthScreen
import com.patidost.app.feature.economy.EconomyScreen
import com.patidost.app.feature.pet_detail.PetDetailScreen
import com.patidost.app.ui.main.MainScreen

object AppDestinations {
    const val AUTH_GRAPH_ROUTE = "auth_graph"
    const val MAIN_GRAPH_ROUTE = "main_graph"
    const val PET_DETAIL_ROUTE = "pet_detail"
    const val ECONOMY_ROUTE = "economy" // EKLEME: Ekonomi rotası mühürlendi
}

object GraphDestinations {
    const val AUTH_SCREEN_ROUTE = "auth"
    const val MAIN_SCREEN_ROUTE = "main_screen"
}

object PetDetailArgs {
    const val PET_ID = "petId"
}

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    // TODO: Add a real logic to decide the start destination based on user login state.
    NavHost(navController = navController, startDestination = AppDestinations.AUTH_GRAPH_ROUTE) {

        navigation(startDestination = GraphDestinations.AUTH_SCREEN_ROUTE, route = AppDestinations.AUTH_GRAPH_ROUTE) {
            composable(GraphDestinations.AUTH_SCREEN_ROUTE) {
                AuthScreen(
                    onLoginSuccess = {
                        navController.navigateToMainGraph()
                    }
                )
            }
        }

        navigation(startDestination = GraphDestinations.MAIN_SCREEN_ROUTE, route = AppDestinations.MAIN_GRAPH_ROUTE) {
            composable(GraphDestinations.MAIN_SCREEN_ROUTE) {
                MainScreen(mainNavController = navController)
            }
            composable(
                route = "${AppDestinations.PET_DETAIL_ROUTE}/{${PetDetailArgs.PET_ID}}",
                arguments = listOf(navArgument(PetDetailArgs.PET_ID) { type = NavType.StringType })
            )
            {
                PetDetailScreen()
            }
            composable(AppDestinations.ECONOMY_ROUTE) {
                EconomyScreen()
            }
        }
    }
}

fun NavHostController.navigateToMainGraph() {
    navigate(AppDestinations.MAIN_GRAPH_ROUTE) {
        popUpTo(AppDestinations.AUTH_GRAPH_ROUTE) {
            inclusive = true
        }
        launchSingleTop = true
    }
}
