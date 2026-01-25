package com.patidost.app.data.mapper

import com.patidost.app.data.local.entity.LikedPetEntity
import com.patidost.app.domain.model.Pet

fun LikedPetEntity.toDomain(): Pet {
    return Pet(
        id = this.petId,
        name = "Unknown",
        breed = "Unknown",
        age = 0,
        imageUrl = "",
        location = "Unknown"
    )
}
