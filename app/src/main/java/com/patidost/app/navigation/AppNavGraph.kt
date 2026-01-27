package com.patidost.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.patidost.feature.auth.AuthScreen
import com.patidost.feature.pet_detail.PetDetailScreen
import com.patidost.app.ui.main.MainScreen

object AppDestinations {
    const val AUTH_GRAPH_ROUTE = "auth_graph"
    const val ONBOARDING_ROUTE = "onboarding"
    const val MAIN_GRAPH_ROUTE = "main_graph"
    const val PET_DETAIL_ROUTE = "pet_detail"
    const val ECONOMY_ROUTE = "economy"
}

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = AppDestinations.AUTH_GRAPH_ROUTE) {

        composable(AppDestinations.AUTH_GRAPH_ROUTE) {
            AuthScreen(
                // onLoginSuccess = { navController.navigateToOnboarding() }
            )
        }

        composable(AppDestinations.ONBOARDING_ROUTE) {
            // OnboardingScreen(
            //     onNavigateToHome = { navController.navigateToMainGraph() }
            // )
        }

        navigation(startDestination = "main_screen_route_placeholder", route = AppDestinations.MAIN_GRAPH_ROUTE) {
            composable("main_screen_route_placeholder") {
                MainScreen(mainNavController = navController)
            }
            composable(
                route = "${AppDestinations.PET_DETAIL_ROUTE}/{petId}",
                arguments = listOf(navArgument("petId") { type = NavType.StringType })
            )
            {
                PetDetailScreen()
            }
            composable(AppDestinations.ECONOMY_ROUTE) {
                // EconomyScreen()
            }
        }
    }
}

fun NavHostController.navigateToOnboarding() {
    navigate(AppDestinations.ONBOARDING_ROUTE) {
        popUpTo(AppDestinations.AUTH_GRAPH_ROUTE) {
            inclusive = true
        }
        launchSingleTop = true
    }
}

fun NavHostController.navigateToMainGraph() {
    navigate(AppDestinations.ONBOARDING_ROUTE) {
        popUpTo(AppDestinations.MAIN_GRAPH_ROUTE) {
            inclusive = true
        }
        launchSingleTop = true
    }
}
