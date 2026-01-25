package com.patidost.app.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.patidost.app.domain.repository.QuotaRepository
import com.patidost.app.domain.utils.AppError
import com.patidost.app.domain.utils.Result
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuotaRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    private val database: FirebaseDatabase
) : QuotaRepository {

    private object PrefKeys {
        val REMAINING_SUPER_LIKES = intPreferencesKey("remaining_super_likes")
        val LAST_RESET_TIMESTAMP = longPreferencesKey("last_reset_timestamp")
    }

    private val WEEK_IN_MILLIS = 7 * 24 * 60 * 60 * 1000L
    private val DEFAULT_QUOTA = 3

    private fun getServerTimeOffset(): Flow<Long> = callbackFlow {
        val offsetRef = database.getReference(".info/serverTimeOffset")
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val offset = snapshot.getValue(Long::class.java) ?: 0L
                trySend(offset)
            }
            override fun onCancelled(error: DatabaseError) { trySend(0L) }
        }
        offsetRef.addValueEventListener(listener)
        awaitClose { offsetRef.removeEventListener(listener) }
    }

    private suspend fun getTrustedTime(): Long {
        val offset = getServerTimeOffset().first()
        return System.currentTimeMillis() + offset
    }

    override fun getRemainingSuperLikes(): Flow<Int> = dataStore.data.map { it[PrefKeys.REMAINING_SUPER_LIKES] ?: DEFAULT_QUOTA }

    override suspend fun consumeSuperLike(): Result<Unit> {
        refreshQuotaIfNeeded()
        val currentLikes = getRemainingSuperLikes().first()
        return if (currentLikes > 0) {
            dataStore.edit { it[PrefKeys.REMAINING_SUPER_LIKES] = currentLikes - 1 }
            Result.Success(Unit)
        } else {
            Result.Error(AppError.QuotaExhaustedError())
        }
    }

    override suspend fun refreshQuotaIfNeeded() {
        val lastReset = dataStore.data.map { it[PrefKeys.LAST_RESET_TIMESTAMP] ?: 0L }.first()
        val trustedTime = getTrustedTime()
        if (trustedTime - lastReset >= WEEK_IN_MILLIS) {
            dataStore.edit {
                it[PrefKeys.REMAINING_SUPER_LIKES] = DEFAULT_QUOTA
                it[PrefKeys.LAST_RESET_TIMESTAMP] = trustedTime
            }
        }
    }
}
