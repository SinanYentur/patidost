package com.patidost.app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for the liked_pets table.
 */
@Dao
interface LikedPetDao {

    /**
     * Inserts a liked pet into the table. If the pet already exists, it will be ignored.
     * @param likedPet The pet to insert.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(likedPet: LikedPetEntity)

    /**
     * Observes the list of all liked pet IDs, ordered by when they were liked.
     * @return A flow of the list of liked pet entities.
     */
    @Query("SELECT * FROM liked_pets ORDER BY timestamp DESC")
    fun getLikedPets(): Flow<List<LikedPetEntity>>
}
