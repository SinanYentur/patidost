package com.patidost.app.feature.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patidost.app.core.navigation.NavigationCommand
import com.patidost.app.core.navigation.Route
import com.patidost.app.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val navigationManager: NavigationManager
) : ViewModel() {
    private val _state = MutableStateFlow(AuthState())
    val state: StateFlow<AuthState> = _state.asStateFlow()

    fun onEvent(event: AuthEvent) {
        when (event) {
            is AuthEvent.EmailChanged -> {
                val sanitizedEmail = event.email.filter { !it.isWhitespace() }
                _state.update { it.copy(email = sanitizedEmail) }
            }
            is AuthEvent.PasswordChanged -> {
                val sanitizedPassword = event.password.filter { !it.isWhitespace() }
                _state.update { it.copy(password = sanitizedPassword) }
            }
            is AuthEvent.ConfirmPasswordChanged -> {
                val sanitizedConfirmPassword = event.password.filter { !it.isWhitespace() }
                _state.update { it.copy(confirmPassword = sanitizedConfirmPassword) }
            }
            is AuthEvent.NameChanged -> {
                _state.update { it.copy(name = event.name.trim()) }
            }
            AuthEvent.TogglePasswordVisibility -> {
                _state.update { it.copy(isPasswordVisible = !it.isPasswordVisible) }
            }
            AuthEvent.ToggleConfirmPasswordVisibility -> {
                _state.update { it.copy(isConfirmPasswordVisible = !it.isConfirmPasswordVisible) }
            }
            AuthEvent.ToggleAuthMode -> {
                val newMode = if (_state.value.authMode is AuthMode.LOGIN) {
                    AuthMode.REGISTER
                } else {
                    AuthMode.LOGIN
                }
                _state.update {
                    it.copy(
                        authMode = newMode,
                        email = "",
                        password = "",
                        confirmPassword = "",
                        name = "",
                        error = null,
                        validationErrors = emptyMap()
                    )
                }
            }
            AuthEvent.LoginWithEmail -> {
                if (validateLogin()) {
                    performLogin()
                }
            }
            AuthEvent.RegisterWithEmail -> {
                if (validateRegister()) {
                    performRegister()
                }
            }
            AuthEvent.LoginWithGoogle -> {
                // Google Login implementasyonu
            }
            AuthEvent.LoginWithFacebook -> {
                // Facebook Login implementasyonu
            }
            AuthEvent.ForgotPassword -> {
                // Forgot Password implementasyonu
            }
            AuthEvent.ClearError -> {
                _state.update { it.copy(error = null) }
            }
        }
    }

    private fun validateLogin(): Boolean {
        val errors = mutableMapOf<String, String>()

        if (_state.value.email.isBlank()) {
            errors["email"] = "E-posta adresi gereklidir"
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(_state.value.email).matches()) {
            errors["email"] = "Geçerli bir e-posta adresi girin"
        }

        if (_state.value.password.isBlank()) {
            errors["password"] = "Parola gereklidir"
        } else if (_state.value.password.length < 6) {
            errors["password"] = "Parola en az 6 karakter olmalıdır"
        }

        _state.update { it.copy(validationErrors = errors) }
        return errors.isEmpty()
    }

    private fun validateRegister(): Boolean {
        val errors = mutableMapOf<String, String>()

        if (_state.value.name.isBlank()) {
            errors["name"] = "İsim gereklidir"
        }

        if (_state.value.email.isBlank()) {
            errors["email"] = "E-posta adresi gereklidir"
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(_state.value.email).matches()) {
            errors["email"] = "Geçerli bir e-posta adresi girin"
        }

        if (_state.value.password.isBlank()) {
            errors["password"] = "Parola gereklidir"
        } else if (_state.value.password.length < 6) {
            errors["password"] = "Parola en az 6 karakter olmalıdır"
        }

        if (_state.value.confirmPassword.isBlank()) {
            errors["confirmPassword"] = "Parola onayı gereklidir"
        } else if (_state.value.password != _state.value.confirmPassword) {
            errors["confirmPassword"] = "Parolalar eşleşmiyor"
        }

        _state.update { it.copy(validationErrors = errors) }
        return errors.isEmpty()
    }

    private fun performLogin() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                // TODO: Gerçek backend entegrasyonu
                kotlinx.coroutines.delay(1500) // Simülasyon
                _state.update { it.copy(isLoading = false) }

                navigationManager.navigate(NavigationCommand.NavigateTo(Route.Onboarding))

            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = "Giriş yapılırken bir hata oluştu: ${e.message}") }
            }
        }
    }

    private fun performRegister() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                // TODO: Gerçek backend entegrasyonu
                kotlinx.coroutines.delay(1500) // Simülasyon
                _state.update { it.copy(isLoading = false, authMode = AuthMode.LOGIN) }

                navigationManager.navigate(NavigationCommand.NavigateTo(Route.Onboarding))

            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = "Kayıt olurken bir hata oluştu: ${e.message}") }
            }
        }
    }
}
