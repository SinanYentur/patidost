package com.patidost.core.data.repository

import com.patidost.core.domain.model.Pet
import com.patidost.core.domain.repository.DiscoveryRepository
import javax.inject.Inject

class MockDiscoveryRepository @Inject constructor() : DiscoveryRepository {
    override suspend fun getPets(): Result<List<Pet>> {
        val mockList = listOf(
            Pet("1", "Pamuk", "Tekir", "2 Yaş", "İstanbul", "", "Dişi"),
            Pet("2", "Baron", "Golden", "1 Yaş", "Ankara", "", "Erkek")
        )
        return Result.success(mockList)
    }

    override suspend fun getPetDetail(petId: String): Result<Pet> {
        return Result.success(Pet(petId, "Detay Pet", "Cins", "Yaş", "Konum", "", "Cinsiyet"))
    }
}
