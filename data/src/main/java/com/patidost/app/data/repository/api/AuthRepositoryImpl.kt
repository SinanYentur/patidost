package com.patidost.app.data.repository.api

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.patidost.app.domain.model.User
import com.patidost.app.domain.repository.AuthRepository
import com.patidost.app.domain.utils.AppError
import com.patidost.app.domain.utils.Result
import kotlinx.coroutines.tasks.await
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {

    override suspend fun loginWithEmail(email: String, password: String): Result<User> {
        return try {
            val authResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            val firebaseUser = authResult.user
                ?: return Result.Error(AppError.UnknownError(IllegalStateException("Firebase user is null after successful login.")))

            val user = User(
                uid = firebaseUser.uid,
                email = firebaseUser.email,
                displayName = firebaseUser.displayName,
                photoUrl = firebaseUser.photoUrl?.toString(),
                isPremium = false
            )
            Result.Success(user)
        } catch (e: FirebaseAuthInvalidUserException) {
            Result.Error(AppError.AuthenticationError("Bu e-posta adresi ile kayıtlı bir kullanıcı bulunamadı."))
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            Result.Error(AppError.AuthenticationError("E-posta veya şifre yanlış."))
        } catch (e: Exception) {
            when (e) {
                is UnknownHostException,
                is ConnectException,
                is SocketTimeoutException -> {
                    Result.Error(AppError.NetworkError("İnternet bağlantınızı kontrol ediniz."))
                }
                else -> Result.Error(AppError.UnknownError(e))
            }
        }
    }

    override suspend fun registerWithEmail(email: String, password: String): Result<User> {
        return Result.Error(AppError.NotImplemented("Register henüz implemente edilmedi."))
    }

    override suspend fun signInWithGoogle(idToken: String): Result<User> {
        return Result.Error(AppError.NotImplemented("Google Sign-In henüz implemente edilmedi."))
    }

    override suspend fun logout(): Result<Unit> {
        firebaseAuth.signOut()
        return Result.Success(Unit)
    }

    override suspend fun getCurrentUser(): Result<User?> {
        val firebaseUser = firebaseAuth.currentUser
        return if (firebaseUser != null) {
            val user = User(
                uid = firebaseUser.uid,
                email = firebaseUser.email,
                displayName = firebaseUser.displayName,
                photoUrl = firebaseUser.photoUrl?.toString(),
                isPremium = false
            )
            Result.Success(user)
        } else {
            Result.Success(null)
        }
    }

    override suspend fun updateUserProfile(user: User): Result<User> {
        // Fake implementation
        return Result.Success(user)
    }
}
