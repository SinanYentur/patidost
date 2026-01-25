package com.patidost.app.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.patidost.app.feature.discovery.DiscoveryScreen
import com.patidost.app.feature.liked_pets.LikedPetsScreen
import com.patidost.app.feature.profile.ProfileScreen
import com.patidost.app.navigation.AppDestinations

@Composable
fun MainScreen(mainNavController: NavHostController) {
    val innerNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = innerNavController)
        }
    ) { innerPadding ->
        NavHost(
            navController = innerNavController,
            startDestination = MainNavigationItem.Discovery.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            // --- OPERASYON TAMAMLANDI: BAĞLANTI KURULDU ---
            composable(MainNavigationItem.Discovery.route) {
                DiscoveryScreen(
                    onPetClick = { petId ->
                        // ARTIK DISCOVERY EKRANINDAN DETAY SAYFASINA GİDİLEBİLİR
                        mainNavController.navigate("${AppDestinations.PET_DETAIL_ROUTE}/$petId")
                    }
                )
            }
            // ---------------------------------------------

            composable(MainNavigationItem.LikedPets.route) {
                LikedPetsScreen(
                    onPetClick = { petId ->
                        mainNavController.navigate("${AppDestinations.PET_DETAIL_ROUTE}/$petId")
                    }
                )
            }
            composable(MainNavigationItem.Profile.route) {
                ProfileScreen(
                    onLogoutSuccess = {
                        mainNavController.navigate(AppDestinations.AUTH_GRAPH_ROUTE) {
                            popUpTo(AppDestinations.MAIN_GRAPH_ROUTE) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        mainNavigationItems.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = screen.label) },
                label = { Text(screen.label) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
