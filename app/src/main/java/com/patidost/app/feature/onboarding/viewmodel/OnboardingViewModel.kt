package com.patidost.app.feature.onboarding.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patidost.app.feature.onboarding.models.OnboardingEvent
import com.patidost.app.feature.onboarding.models.OnboardingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class OnboardingViewModel : ViewModel() {

    private val _state = MutableStateFlow(OnboardingState())
    val state: StateFlow<OnboardingState> = _state.asStateFlow()

    fun onEvent(event: OnboardingEvent) {
        when (event) {
            is OnboardingEvent.PetStatusSelected -> selectPetStatus(event.hasPet)
            OnboardingEvent.ContinueClicked -> continueToHomeScreen()
            OnboardingEvent.SkipForLaterClicked -> skipForLater()
            OnboardingEvent.NavigationHandled -> handleNavigation()
        }
    }

    private fun selectPetStatus(hasPet: Boolean) {
        _state.update { it.copy(petStatus = hasPet) }
    }

    private fun continueToHomeScreen() {
        if (_state.value.petStatus == null) return

        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            // Simulate saving preference
            kotlinx.coroutines.delay(500)
            _state.update {
                it.copy(
                    isLoading = false,
                    navigationEvent = OnboardingState.NavigationEvent.NavigateToHome
                )
            }
        }
    }

    private fun skipForLater() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    petStatus = null,
                    navigationEvent = OnboardingState.NavigationEvent.NavigateToHome
                )
            }
        }
    }

    private fun handleNavigation() {
        _state.update { it.copy(navigationEvent = null) }
    }
}
