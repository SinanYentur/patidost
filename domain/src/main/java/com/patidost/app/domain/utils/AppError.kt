package com.patidost.app.domain.utils

/**
 * A standardized error class for the entire application.
 * All errors must provide a user-facing message.
 */
sealed class AppError(open val message: String) {
    data class NetworkError(override val message: String) : AppError(message)
    data class DatabaseError(override val message: String) : AppError(message)
    data class AuthenticationError(override val message: String) : AppError(message)
    data class UnknownError(val cause: Throwable) : AppError(cause.message ?: "An unknown error occurred")
    data class NotImplemented(override val message: String) : AppError(message)
}
