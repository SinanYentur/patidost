package com.patidost.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.patidost.core.common.navigation.Screen
import com.patidost.feature.auth.LoginScreen
import com.patidost.feature.auth.RegisterScreen
import com.patidost.feature.discovery.DiscoveryScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.AuthGraph.route
    ) {
        // --- AUTH ROTASI ---
        // 1. Graph Başlangıcı (Login)
        composable(Screen.AuthGraph.route) {
            LoginScreen(
                onLoginClick = {
                    // Giriş başarılıysa Ana Sayfaya git
                    navController.navigate(Screen.MainGraph.route) {
                        popUpTo(Screen.AuthGraph.route) { inclusive = true }
                    }
                },
                onRegisterClick = {
                    navController.navigate(Screen.Register.route)
                }
            )
        }

        // 2. Register Ekranı
        composable(Screen.Register.route) {
            RegisterScreen(
                onRegisterClick = {
                    // Kayıt olunca Ana Sayfaya git
                    navController.navigate(Screen.MainGraph.route) {
                        popUpTo(Screen.AuthGraph.route) { inclusive = true }
                    }
                },
                onLoginClick = {
                    navController.popBackStack() // Geri dön
                }
            )
        }

        // --- ANA UYGULAMA ROTASI ---
        composable(Screen.MainGraph.route) {
            DiscoveryScreen(
                onPetClick = { petId ->
                    // Detay sayfasına git (Henüz hazır değil, log basabiliriz)
                    println("Pet tıklandı: $petId")
                }
            )
        }
    }
}
