package com.patidost.core.data.repository

import com.patidost.core.domain.repository.AuthRepository
import javax.inject.Inject

class MockAuthRepository @Inject constructor() : AuthRepository {
    override suspend fun login(email: String, password: String): Result<Boolean> {
        // Mock: Her zaman başarılı
        return Result.success(true)
    }

    override suspend fun register(name: String, email: String, password: String): Result<Boolean> {
        return Result.success(true)
    }

    override suspend fun logout() {
        // No-op
    }

    override fun isLoggedIn(): Boolean {
        return false
    }
}
