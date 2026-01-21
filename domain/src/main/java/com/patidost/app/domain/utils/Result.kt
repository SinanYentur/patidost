package com.patidost.app.domain.utils

/**
 * A generic class that holds a value with its loading status.
 * @param <T> The type of the value.
 */
sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Error(val error: AppError) : Result<Nothing>
    object Loading : Result<Nothing>
}
