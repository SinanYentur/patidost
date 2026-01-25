package com.patidost.app.data.local

import androidx.room.TypeConverter
import com.patidost.app.data.local.entity.SyncState

class Converters {
    @TypeConverter
    fun fromSyncState(value: SyncState): String {
        return value.name
    }

    @TypeConverter
    fun toSyncState(value: String): SyncState {
        return try {
            enumValueOf<SyncState>(value)
        } catch (e: Exception) {
            SyncState.FATAL // Bilinmeyen bir değer gelirse FATAL dön.
        }
    }
}