package com.patidost.app.data.source.remote

import com.patidost.app.domain.model.Pet
import com.patidost.app.domain.utils.Result

interface PetRemoteDataSource {
    suspend fun syncLike(pet: Pet): Result<Unit>
}