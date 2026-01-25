package com.patidost.app.domain.repository

interface PetSyncRepository {
    suspend fun runSyncEngine(): Boolean
}