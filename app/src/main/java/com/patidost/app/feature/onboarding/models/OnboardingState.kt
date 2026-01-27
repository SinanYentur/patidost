package com.patidost.app.feature.onboarding.models

data class OnboardingState(
    val petStatus: Boolean? = null,
    val isLoading: Boolean = false,
    val navigationEvent: NavigationEvent? = null
) {
    val isContinueEnabled: Boolean get() = petStatus != null

    sealed class NavigationEvent {
        object NavigateToHome : NavigationEvent()
    }
}
