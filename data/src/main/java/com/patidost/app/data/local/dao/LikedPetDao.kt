package com.patidost.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.patidost.app.data.local.entity.LikedPetEntity
import com.patidost.app.data.local.entity.SyncState
import kotlinx.coroutines.flow.Flow

@Dao
interface LikedPetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: LikedPetEntity)

    @Query("DELETE FROM liked_pets WHERE petId = :petId")
    suspend fun delete(petId: String)

    @Query("SELECT * FROM liked_pets ORDER BY likedAt DESC")
    fun getLikedPets(): Flow<List<LikedPetEntity>>

    @Query("""
        SELECT * FROM liked_pets 
        WHERE syncState = 'PENDING' 
           OR (syncState = 'RETRY' AND nextRetryTime <= :currentTime)
        LIMIT 10
    """)
    suspend fun _getQueueInternal(currentTime: Long): List<LikedPetEntity>

    @Query("UPDATE liked_pets SET syncState = 'IN_PROGRESS' WHERE petId IN (:ids)")
    suspend fun _markInternal(ids: List<String>)

    @Transaction
    suspend fun getAndLockQueueItems(currentTime: Long): List<LikedPetEntity> {
        val items = _getQueueInternal(currentTime)
        if (items.isNotEmpty()) {
            val ids = items.map { it.petId }
            _markInternal(ids)
        }
        return items
    }

    @Query("""
        UPDATE liked_pets 
        SET syncState = :newState, 
            retryCount = :newRetryCount, 
            nextRetryTime = :newNextRetryTime 
        WHERE petId = :petId
    """)
    suspend fun updateSyncStatus(
        petId: String, 
        newState: SyncState, 
        newRetryCount: Int, 
        newNextRetryTime: Long
    )
}