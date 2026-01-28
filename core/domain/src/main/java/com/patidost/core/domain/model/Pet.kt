// @pin: [FAZ0-001] Bu model, projenin temel problemini çözmek için var olan bir varlıktır.

package com.patidost.core.domain.model

data class Pet(
    val id: String,
    val name: String,
    val breed: String,
    val age: String,
    val location: String,
    val imageUrl: String,
    val gender: String
)
