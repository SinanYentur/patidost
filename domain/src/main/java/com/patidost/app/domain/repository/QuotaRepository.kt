package com.patidost.app.domain.repository

import com.patidost.app.domain.utils.Result
import kotlinx.coroutines.flow.Flow

interface QuotaRepository {
    /**
     * Gets the number of remaining Super Likes for the current week.
     */
    fun getRemainingSuperLikes(): Flow<Int>

    /**
     * Attempts to consume one Super Like.
     * Returns Success if quota was available and consumed.
     * Returns Error if quota is exhausted.
     */
    suspend fun consumeSuperLike(): Result<Unit>

    /**
     * Checks if the week has passed and resets the quota to 3 if needed.
     * This should be called on app start or appropriate lifecycle events.
     */
    suspend fun refreshQuotaIfNeeded()
}
