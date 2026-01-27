package com.patidost.app.core.navigation

import androidx.navigation.NavOptions

sealed class NavigationCommand {
    data class NavigateTo(val route: Route, val options: NavOptions? = null) : NavigationCommand()
    object NavigateUp : NavigationCommand()
}
