package com.patidost.core.common.navigation

/**
 * Bu dosya, uygulamanın HARİTASIDIR.
 * Gelecek AI (Gemini 2.5), yeni bir ekran eklerken sadece buraya bir satır ekleyecektir.
 */

sealed class Screen(val route: String) {
    // Auth Rotası
    data object AuthGraph : Screen("auth_graph")
    data object Login : Screen("login")
    data object Register : Screen("register")
    
    // Ana Uygulama Rotası
    data object MainGraph : Screen("main_graph")
    data object Discovery : Screen("discovery")
    data object Profile : Screen("profile")
    
    // Detay Rotası (Argümanlı Örnek)
    data object PetDetail : Screen("pet_detail/{petId}") {
        fun createRoute(petId: String) = "pet_detail/$petId"
    }
}
