package com.patidost.app.data.repository

import com.patidost.app.data.di.IoDispatcher
import com.patidost.app.data.local.dao.LikedPetDao
import com.patidost.app.data.local.entity.LikedPetEntity
import com.patidost.app.data.local.entity.SyncState
import com.patidost.app.data.mapper.toDomain
import com.patidost.app.data.source.remote.PetRemoteDataSource
import com.patidost.app.domain.repository.PetSyncRepository
import com.patidost.app.domain.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.math.min

class PetSyncRepositoryImpl @Inject constructor(
    private val localDataSource: LikedPetDao,
    private val remoteDataSource: PetRemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : PetSyncRepository {

    private val MAX_BACKOFF_MILLIS = 60 * 60 * 1000L

    override suspend fun runSyncEngine(): Boolean = withContext(ioDispatcher) {
        val itemsToSync = localDataSource.getAndLockQueueItems(System.currentTimeMillis())
        if (itemsToSync.isEmpty()) return@withContext true

        var allSuccess = true

        itemsToSync.forEach { item ->
            try {
                // Varsayımsal API çağrısı
                val result = remoteDataSource.syncLike(item.toDomain())

                when (result) {
                    is Result.Success -> {
                        localDataSource.updateSyncStatus(
                            petId = item.petId,
                            newState = SyncState.SYNCED,
                            newRetryCount = 0,
                            newNextRetryTime = 0
                        )
                    }
                    is Result.Error -> {
                        allSuccess = false
                        handleFailure(item, 500) // Genel bir sunucu hatası varsayıyoruz
                    }
                    else -> {}
                }
            } catch (e: Exception) {
                allSuccess = false
                handleFailure(item, 500)
            }
        }
        allSuccess
    }

    private suspend fun handleFailure(item: LikedPetEntity, errorCode: Int) {
        val newRetryCount = item.retryCount + 1
        if (errorCode >= 400 && errorCode < 500) {
            localDataSource.updateSyncStatus(item.petId, SyncState.FATAL, newRetryCount, 0)
            return
        }
        
        if (newRetryCount > 10) {
            localDataSource.updateSyncStatus(item.petId, SyncState.FATAL, newRetryCount, 0)
        } else {
            val backoff = min(
                (10_000L * (1 shl (newRetryCount - 1))),
                MAX_BACKOFF_MILLIS
            )
            localDataSource.updateSyncStatus(
                petId = item.petId,
                newState = SyncState.RETRY,
                newRetryCount = newRetryCount,
                newNextRetryTime = System.currentTimeMillis() + backoff
            )
        }
    }
}