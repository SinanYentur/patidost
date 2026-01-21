package com.patidost.app.ui.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Represents the tabs in the main bottom navigation bar.
 */
sealed class MainNavigationItem(val route: String, val label: String, val icon: ImageVector) {
    object Discovery : MainNavigationItem("discovery_tab", "Keşfet", Icons.Default.Search)
    object LikedPets : MainNavigationItem("liked_pets_tab", "Beğenilenler", Icons.Default.Favorite)
    object Profile : MainNavigationItem("profile_tab", "Profil", Icons.Default.Person)
}

val mainNavigationItems = listOf(
    MainNavigationItem.Discovery,
    MainNavigationItem.LikedPets,
    MainNavigationItem.Profile,
)
