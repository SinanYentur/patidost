package com.patidost.core.domain.auth

/**
 * Veri katmanı ile iletişim sözleşmesi.
 * @see AuthResult
 */
interface AuthRepository {
    suspend fun login(email: String, pass: String): AuthResult
    suspend fun register(email: String, pass: String): AuthResult
    fun isLoggedIn(): Boolean
}
