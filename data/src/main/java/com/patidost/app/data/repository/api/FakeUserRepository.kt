package com.patidost.app.data.repository.api

import com.patidost.app.domain.model.User
import com.patidost.app.domain.repository.UserRepository
import com.patidost.app.domain.utils.AppError
import com.patidost.app.domain.utils.Result
import kotlinx.coroutines.delay

/**
 * A fake implementation of [UserRepository] for UI previews and testing.
 */
@Deprecated("This class is for UI previews and testing only. Do not use in production.")
class FakeUserRepository : UserRepository {
    override suspend fun loginWithEmail(email: String, password: String): Result<User> {
        delay(1000)
        return if (email == "test@patidost.com" && password == "123456") {
            Result.Success(
                User(
                    uid = "123",
                    email = email,
                    displayName = "Test User",
                    photoUrl = null,
                    isPremium = false
                )
            )
        } else {
            Result.Error(AppError.AuthenticationError("Invalid credentials"))
        }
    }

    override suspend fun registerWithEmail(email: String, password: String): Result<User> {
        return Result.Error(AppError.NotImplemented("Not implemented in fake"))
    }

    override suspend fun signInWithGoogle(idToken: String): Result<User> {
        return Result.Error(AppError.NotImplemented("Not implemented in fake"))
    }

    override suspend fun logout(): Result<Unit> {
        return Result.Success(Unit)
    }

    override suspend fun getCurrentUser(): Result<User?> {
        return Result.Success(null)
    }

    override suspend fun likePet(petId: String): Result<Unit> {
        return Result.Success(Unit)
    }
}
