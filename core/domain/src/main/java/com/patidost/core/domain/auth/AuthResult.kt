package com.patidost.core.domain.auth

/**
 * Giriş işlemi sonuçlarını modelleyen anayasal sözleşme.
 * Exception fırlatmak YASAKTIR. Tüm hatalar Error state olarak dönmelidir.
 */
sealed interface AuthResult {
    data class Success(val userId: String, val userName: String) : AuthResult
    data object Loading : AuthResult
    
    sealed interface Error : AuthResult {
        data class Network(val message: String) : Error
        data class InvalidCredentials(val message: String) : Error
        data class Unknown(val cause: Throwable?) : Error
    }
}
