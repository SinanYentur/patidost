package com.patidost.feature.discovery.domain

data class Pet(
    val id: String,
    val name: String,
    val breed: String,
    val age: String,
    val location: String,
    val imageUrl: String, // Şimdilik yerel drawable veya renk kodu olacak
    val gender: String
)
