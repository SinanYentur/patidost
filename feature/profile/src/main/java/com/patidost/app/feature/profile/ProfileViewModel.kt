package com.patidost.app.feature.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patidost.app.domain.model.User
import com.patidost.app.domain.repository.AuthRepository
import com.patidost.app.domain.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ProfileUiState(
    val user: User? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val isLoggedOut: Boolean = false
)

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadCurrentUser()
    }

    private fun loadCurrentUser() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            when (val result = authRepository.getCurrentUser()) {
                is Result.Success -> {
                    _uiState.update { it.copy(isLoading = false, user = result.data) }
                }
                is Result.Error -> {
                    _uiState.update { it.copy(isLoading = false, error = result.error.message) }
                }
                else -> { /* No-op */ }
            }
        }
    }

    fun onBioChanged(newBio: String) {
        _uiState.value.user?.let {
            updateProfile(it.copy(bio = newBio))
        }
    }

    private fun updateProfile(user: User) {
        viewModelScope.launch {
            // Optimistically update the UI
            _uiState.update { it.copy(user = user) }

            when (val result = authRepository.updateUserProfile(user)) {
                is Result.Success -> {
                    // Data is already updated, do nothing or show a success message
                }
                is Result.Error -> {
                    // Revert the change on error and show a message
                    loadCurrentUser() // Re-fetch the original state
                    _uiState.update { it.copy(error = "Profile update failed.") }
                }
                else -> {}
            }
        }
    }

    fun onLogoutClicked() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            when (authRepository.logout()) {
                is Result.Success -> {
                    _uiState.update { it.copy(isLoading = false, isLoggedOut = true) }
                }
                is Result.Error -> {
                    _uiState.update { it.copy(isLoading = false, error = "Logout failed. Please try again.") }
                }
                else -> { /* No-op */ }
            }
        }
    }

    fun onNavigationDone() {
        _uiState.update { it.copy(isLoggedOut = false) }
    }
}
