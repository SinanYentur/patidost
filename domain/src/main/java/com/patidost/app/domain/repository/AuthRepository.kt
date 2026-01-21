package com.patidost.app.domain.repository

import com.patidost.app.domain.model.User
import com.patidost.app.domain.utils.Result

interface AuthRepository {
    suspend fun loginWithEmail(email: String, password: String): Result<User>
    suspend fun registerWithEmail(email: String, password: String): Result<User>
    suspend fun signInWithGoogle(idToken: String): Result<User>
    suspend fun logout(): Result<Unit>
    suspend fun getCurrentUser(): Result<User?>
    suspend fun updateUserProfile(user: User): Result<User>
}
