package com.patidost.core.domain.repository

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<Boolean>
    suspend fun register(name: String, email: String, password: String): Result<Boolean>
    suspend fun logout()
    fun isLoggedIn(): Boolean
}
