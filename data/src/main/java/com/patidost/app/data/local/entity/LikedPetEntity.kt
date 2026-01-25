package com.patidost.app.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "liked_pets")
data class LikedPetEntity(
    @PrimaryKey val petId: String,
    val name: String = "",
    val imageUrl: String = "",
    val breed: String = "",
    val age: Int = 0,
    val location: String = "",
    val likedAt: Long = System.currentTimeMillis(),
    
    @ColumnInfo(defaultValue = "'PENDING'")
    val syncState: SyncState = SyncState.PENDING,
    
    @ColumnInfo(defaultValue = "0")
    val retryCount: Int = 0,

    @ColumnInfo(defaultValue = "0")
    val nextRetryTime: Long = 0
)
