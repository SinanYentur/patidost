package com.patidost.app.domain.model

import java.util.Date

data class User(
    val uid: String,
    val email: String?,
    val displayName: String?,
    val photoUrl: String?,
    val bio: String? = null,
    val birthDate: Date? = null,
    val isPremium: Boolean = false
)
