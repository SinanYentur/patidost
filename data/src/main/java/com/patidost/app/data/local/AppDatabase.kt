package com.patidost.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.patidost.app.data.local.dao.LikedPetDao
import com.patidost.app.data.local.entity.LikedPetEntity

@Database(
    entities = [LikedPetEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun likedPetDao(): LikedPetDao
}
