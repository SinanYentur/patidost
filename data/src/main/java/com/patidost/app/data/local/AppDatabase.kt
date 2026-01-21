package com.patidost.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * The main database for the application.
 */
@Database(entities = [LikedPetEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun likedPetDao(): LikedPetDao
}
