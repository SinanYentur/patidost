package com.patidost.app.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.patidost.app.domain.repository.QuotaRepository
import com.patidost.app.domain.utils.AppError
import com.patidost.app.domain.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.util.Calendar
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuotaRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    private val crashlytics: FirebaseCrashlytics
) : QuotaRepository {

    private object PrefKeys {
        val REMAINING_SUPER_LIKES = intPreferencesKey("remaining_super_likes")
        val LAST_RESET_TIMESTAMP = longPreferencesKey("last_reset_timestamp")
    }

    private val WEEK_IN_MILLIS = 7 * 24 * 60 * 60 * 1000L
    private val DEFAULT_QUOTA = 3

    override fun getRemainingSuperLikes(): Flow<Int> {
        return dataStore.data.map { preferences ->
            preferences[PrefKeys.REMAINING_SUPER_LIKES] ?: DEFAULT_QUOTA
        }
    }

    override suspend fun consumeSuperLike(): Result<Unit> {
        refreshQuotaIfNeeded()

        val currentLikes = getRemainingSuperLikes().first()

        return if (currentLikes > 0) {
            dataStore.edit { preferences ->
                preferences[PrefKeys.REMAINING_SUPER_LIKES] = currentLikes - 1
            }
            Result.Success(Unit)
        } else {
            // Log a non-fatal error to Crashlytics for monitoring quota depletion events
            crashlytics.recordException(QuotaExhaustedException("User tried to use Super Like but quota was 0."))
            Result.Error(AppError.DatabaseError("Haftalık Super Like hakkınız doldu."))
        }
    }

    override suspend fun refreshQuotaIfNeeded() {
        val lastReset = dataStore.data.map { it[PrefKeys.LAST_RESET_TIMESTAMP] ?: 0L }.first()
        val currentTime = System.currentTimeMillis()

        if (currentTime - lastReset >= WEEK_IN_MILLIS) {
            dataStore.edit { preferences ->
                preferences[PrefKeys.REMAINING_SUPER_LIKES] = DEFAULT_QUOTA
                preferences[PrefKeys.LAST_RESET_TIMESTAMP] = currentTime
            }
        }
    }
}

/**
 * Custom exception for tracking when users run out of Super Likes.
 */
class QuotaExhaustedException(message: String) : Exception(message)
