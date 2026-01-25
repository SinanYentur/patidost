package com.patidost.app.data.source.remote

import com.patidost.app.domain.model.Pet
import com.patidost.app.domain.utils.Result
import kotlinx.coroutines.delay
import javax.inject.Inject

class PetRemoteDataSourceImpl @Inject constructor() : PetRemoteDataSource {
    override suspend fun syncLike(pet: Pet): Result<Unit> {
        // Üretim Simülasyonu: Ağ gecikmesi taklidi ve başarılı dönüş
        delay(500) 
        return Result.Success(Unit)
    }
}