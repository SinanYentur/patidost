package com.patidost.app.domain.model

/**
 * Represents the core data model for a pet.
 */
data class Pet(
    val id: String,
    val name: String,
    val breed: String,
    val age: Int,
    val imageUrl: String,
    val location: String
)
