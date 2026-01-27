package com.patidost.app.core.navigation

sealed class Route(val path: String) {
    data object Auth : Route("auth_graph")
    data object Onboarding : Route("onboarding_screen")
    data object Main : Route("main_graph")
    
    // data class PetDetail(val petId: String) : Route("pet_detail/$petId")
}
