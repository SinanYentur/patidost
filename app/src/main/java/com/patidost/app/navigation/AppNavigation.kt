package com.patidost.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.patidost.core.common.navigation.Screen
import com.patidost.feature.auth.AuthScreen // LoginScreen -> AuthScreen olarak düzeltildi
// import com.patidost.feature.auth.RegisterScreen // Henüz RegisterScreen yok, iskelet kullanılacak
import com.patidost.feature.discovery.DiscoveryScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.AuthGraph.route
    ) {
        // --- AUTH ROTASI ---
        composable(Screen.AuthGraph.route) {
            AuthScreen(
                // onLoginClick = { 
                //     navController.navigate(Screen.MainGraph.route) {
                //         popUpTo(Screen.AuthGraph.route) { inclusive = true }
                //     }
                // },
                // onRegisterClick = {
                //     navController.navigate(Screen.Register.route)
                // }
            )
        }

        // composable(Screen.Register.route) {
        //     // RegisterScreen() // Henüz bu ekran yok
        // }

        // --- ANA UYGULAMA ROTASI ---
        composable(Screen.MainGraph.route) {
            // ANAYASAL ONARIM: Parametre, iskelet yapıya uyması için kaldırıldı
            DiscoveryScreen(
                // onPetClick = { petId ->
                //     println("Pet tıklandı: $petId")
                // }
            )
        }
    }
}
