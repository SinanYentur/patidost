package com.patidost.app.data.repository

import com.patidost.app.data.local.dao.LikedPetDao
import com.patidost.app.data.local.entity.LikedPetEntity
import com.patidost.app.domain.model.Pet
import com.patidost.app.domain.repository.PetRepository
import com.patidost.app.domain.utils.AppError
import com.patidost.app.domain.utils.Result
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PetRepositoryImpl @Inject constructor(
    private val likedPetDao: LikedPetDao
) : PetRepository {

    // A fake data source to simulate a remote API and pet details
    private val allPetsMap = listOf(
        Pet("1", "Sımon", "Golden Retriever", 2, "https://storage.googleapis.com/patidost-prod/pets/simon.jpg", "Istanbul, Turkey"),
        Pet("2", "Luna", "Siberian Husky", 3, "https://storage.googleapis.com/patidost-prod/pets/luna.jpg", "Ankara, Turkey"),
        Pet("3", "Max", "German Shepherd", 4, "https://storage.googleapis.com/patidost-prod/pets/max.jpg", "Izmir, Turkey"),
        Pet("4", "Bella", "Poodle", 1, "https://storage.googleapis.com/patidost-prod/pets/bella.jpg", "Bursa, Turkey"),
        Pet("5", "Charlie", "Beagle", 5, "https://storage.googleapis.com/patidost-prod/pets/charlie.jpg", "Antalya, Turkey")
    ).associateBy { it.id }

    override suspend fun getPets(): Result<List<Pet>> {
        return try {
            delay(1500)
            Result.Success(allPetsMap.values.shuffled())
        } catch (e: Exception) {
            Result.Error(AppError.NetworkError("Failed to fetch pets. Please check your connection."))
        }
    }

    override suspend fun likePet(petId: String): Result<Unit> {
        return try {
            val likedPet = LikedPetEntity(petId = petId)
            likedPetDao.insert(likedPet)
            Result.Success(Unit)
        } catch (e: Exception) {
            Result.Error(AppError.UnknownError(e))
        }
    }

    override fun getLikedPets(): Flow<List<Pet>> {
        return likedPetDao.getLikedPets().map { likedPetEntities ->
            likedPetEntities.mapNotNull { entity ->
                allPetsMap[entity.petId]
            }
        }
    }

    override suspend fun getPetById(petId: String): Result<Pet> {
        // Simulate network delay
        delay(500)
        val pet = allPetsMap[petId]
        return if (pet != null) {
            Result.Success(pet)
        } else {
            Result.Error(AppError.DatabaseError("Pet with id $petId not found."))
        }
    }
}
