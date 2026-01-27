package com.patidost.core.domain.auth

/**
 * Sadece giriş mantığından sorumlu UseCase.
 * Validasyon kuralları burada işletilir.
 */
class LoginUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(email: String, pass: String): AuthResult {
        // 1. Validasyon Kuralları
        if (email.isBlank()) {
            return AuthResult.Error.InvalidCredentials("E-posta boş olamaz.")
        }
        if (pass.isBlank()) {
            return AuthResult.Error.InvalidCredentials("Şifre boş olamaz.")
        }
        
        // 2. Repository Çağrısı
        return try {
            repository.login(email, pass)
        } catch (e: Exception) {
            // Sözleşme gereği Exception yakalanıp State'e dönüştürülür
            AuthResult.Error.Unknown(e)
        }
    }
}
