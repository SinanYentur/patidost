package com.patidost.app.data.di

import android.content.Context
import androidx.room.Room
import com.patidost.app.data.local.AppDatabase
import com.patidost.app.data.local.LikedPetDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "patidost_database"
        ).build()
    }

    @Provides
    fun provideLikedPetDao(appDatabase: AppDatabase): LikedPetDao {
        return appDatabase.likedPetDao()
    }
}
