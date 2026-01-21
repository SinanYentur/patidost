package com.patidost.app.feature.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patidost.app.domain.repository.AuthRepository
import com.patidost.app.domain.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AuthState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val isLoginSuccessful: Boolean = false // Renamed for clarity
)

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AuthState())
    val uiState = _uiState.asStateFlow()

    fun onEmailChanged(email: String) {
        _uiState.update { it.copy(email = email) }
    }

    fun onPasswordChanged(password: String) {
        _uiState.update { it.copy(password = password) }
    }

    fun onLoginWithEmailClicked() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }

            when (val result = authRepository.loginWithEmail(uiState.value.email, uiState.value.password)) {
                is Result.Success -> {
                    _uiState.update { it.copy(isLoading = false, isLoginSuccessful = true) }
                }
                is Result.Error -> {
                    _uiState.update { it.copy(isLoading = false, error = result.error.message) } // FIXED
                }
                is Result.Loading -> { /* Handled by initial isLoading update */ }
            }
        }
    }

    /**
     * Called by the UI after the navigation event has been handled.
     */
    fun onNavigationDone() {
        _uiState.update { it.copy(isLoginSuccessful = false) }
    }
}
