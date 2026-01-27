package com.patidost.app.feature.onboarding.models

sealed class OnboardingEvent {
    data class PetStatusSelected(val hasPet: Boolean) : OnboardingEvent()
    object ContinueClicked : OnboardingEvent()
    object SkipForLaterClicked : OnboardingEvent()
    object NavigationHandled : OnboardingEvent()
}
