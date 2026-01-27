package com.patidost.app.core.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigationManagerImpl @Inject constructor() : NavigationManager {
    private val _commands = MutableSharedFlow<NavigationCommand>()
    override val commands = _commands.asSharedFlow()

    override suspend fun navigate(command: NavigationCommand) {
        _commands.emit(command)
    }
}
