package com.patidost.app.domain.repository

import com.patidost.app.domain.model.Pet
import com.patidost.app.domain.utils.Result
import kotlinx.coroutines.flow.Flow

interface PetRepository {
    suspend fun getPets(): Result<List<Pet>>
    suspend fun likePet(petId: String): Result<Unit>
    fun getLikedPets(): Flow<List<Pet>>
    suspend fun getPetById(petId: String): Result<Pet>
}
