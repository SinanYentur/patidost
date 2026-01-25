package com.patidost.app.data.repository.api

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.userProfileChangeRequest
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
        return try {
            // GERÇEK KAYIT İŞLEMİ
            val authResult = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            val firebaseUser = authResult.user
                ?: return Result.Error(AppError.UnknownError(IllegalStateException("Kayıt sonrası kullanıcı bulunamadı.")))

            val user = User(
                uid = firebaseUser.uid,
                email = firebaseUser.email,
                displayName = firebaseUser.displayName,
                photoUrl = firebaseUser.photoUrl?.toString(),
                isPremium = false
            )
            Result.Success(user)
        } catch (e: Exception) {
            Result.Error(AppError.AuthenticationError("Kayıt işlemi başarısız: ${e.localizedMessage}"))
        }
    }

    override suspend fun signInWithGoogle(idToken: String): Result<User> {
        return try {
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            val authResult = firebaseAuth.signInWithCredential(credential).await()
            val firebaseUser = authResult.user
                ?: return Result.Error(AppError.UnknownError(IllegalStateException("Firebase user is null after successful Google sign-in.")))

            val user = User(
                uid = firebaseUser.uid,
                email = firebaseUser.email,
                displayName = firebaseUser.displayName,
                photoUrl = firebaseUser.photoUrl?.toString(),
                isPremium = false
            )
            Result.Success(user)
        } catch (e: Exception) {
            when (e) {
                is UnknownHostException,
                is ConnectException,
                is SocketTimeoutException -> {
                    Result.Error(AppError.NetworkError("İnternet bağlantınızı kontrol ediniz."))
                }
                is FirebaseAuthInvalidCredentialsException -> {
                    Result.Error(AppError.AuthenticationError("Google kimlik bilgileri geçersiz."))
                }
                else -> Result.Error(AppError.UnknownError(e))
            }
        }
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
        return try {
            val firebaseUser = firebaseAuth.currentUser
                ?: return Result.Error(AppError.AuthenticationError("Oturum açmış kullanıcı bulunamadı."))

            // FIREBASE AUTH PROFİLİNİ GÜNCELLEME (İsim ve Fotoğraf)
            val profileUpdates = userProfileChangeRequest {
                displayName = user.displayName
                photoUri = android.net.Uri.parse(user.photoUrl)
            }

            firebaseUser.updateProfile(profileUpdates).await()
            Result.Success(user)
        } catch (e: Exception) {
            Result.Error(AppError.UnknownError(e))
        }
    }
}
