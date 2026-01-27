package com.patidost.core.domain.repository

import com.patidost.core.domain.model.Pet

interface DiscoveryRepository {
    suspend fun getPets(): Result<List<Pet>>
    suspend fun getPetDetail(petId: String): Result<Pet>
}
