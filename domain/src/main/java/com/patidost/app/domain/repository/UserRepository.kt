package com.patidost.app.domain.repository

import com.patidost.app.domain.model.User
import com.patidost.app.domain.utils.Result

/**
 * @deprecated This interface violates the Single Responsibility Principle.
 * Use [AuthRepository] for authentication tasks and [PetRepository] for pet-related tasks.
 */
@Deprecated(
    "This interface violates SRP. Use AuthRepository and PetRepository instead.",
    ReplaceWith("AuthRepository")
)
interface UserRepository {
    suspend fun loginWithEmail(email: String, password: String): Result<User>
    suspend fun registerWithEmail(email: String, password: String): Result<User>
    suspend fun signInWithGoogle(idToken: String): Result<User>
    suspend fun logout(): Result<Unit>
    suspend fun getCurrentUser(): Result<User?>
    suspend fun likePet(petId: String): Result<Unit>
}
