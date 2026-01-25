package com.patidost.app.domain.utils

sealed class AppError(open val message: String) {
    data class NetworkError(override val message: String) : AppError(message)
    data class DatabaseError(override val message: String) : AppError(message)
    data class AuthenticationError(override val message: String) : AppError(message)
    data class UnknownError(val cause: Throwable) : AppError(cause.message ?: "An unknown error occurred")
    data class NotImplemented(override val message: String) : AppError(message)

    /**
     * 2026 EKONOMİ MÜHRÜ: Haftalık kotanın dolduğunu belirten iş mantığı hatası.
     */
    data class QuotaExhaustedError(
        override val message: String = "Haftalık Super Like hakkınız doldu."
    ) : AppError(message)
}