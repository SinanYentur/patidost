package com.patidost.app.feature.auth

sealed class AuthMode {
    object LOGIN : AuthMode()
    object REGISTER : AuthMode()
}

data class AuthState(
    val authMode: AuthMode = AuthMode.LOGIN,
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "", // Sadece REGISTER modunda kullanılır
    val name: String = "", // Sadece REGISTER modunda kullanılır
    val isPasswordVisible: Boolean = false,
    val isConfirmPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null,
    val validationErrors: Map<String, String> = emptyMap()
)

sealed class AuthEvent {
    data class EmailChanged(val email: String) : AuthEvent()
    data class PasswordChanged(val password: String) : AuthEvent()
    data class ConfirmPasswordChanged(val password: String) : AuthEvent()
    data class NameChanged(val name: String) : AuthEvent()
    object TogglePasswordVisibility : AuthEvent()
    object ToggleConfirmPasswordVisibility : AuthEvent()
    object ToggleAuthMode : AuthEvent()
    object LoginWithEmail : AuthEvent()
    object RegisterWithEmail : AuthEvent()
    object LoginWithGoogle : AuthEvent()
    object LoginWithFacebook : AuthEvent()
    object ForgotPassword : AuthEvent()
    object ClearError : AuthEvent()
}
