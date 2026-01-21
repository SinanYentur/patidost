package com.patidost.app.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a liked pet in the local database.
 */
@Entity(tableName = "liked_pets")
data class LikedPetEntity(
    @PrimaryKey
    val petId: String,
    val timestamp: Long = System.currentTimeMillis()
)
