package com.patidost.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.patidost.core.common.navigation.Screen

// Placeholder (Geçici) Ekranlar - Gemini 2.5 bunları dolduracak
import androidx.compose.material3.Text

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.AuthGraph.route
    ) {
        // AUTH GRAFİĞİ
        composable(Screen.AuthGraph.route) {
            // Şimdilik direkt Login'e yönlendiriyoruz
            // Gemini 2.5 buraya AuthNavigation graph'ini bağlayacak
            Text(text = "Auth Graph Başlangıç Noktası (Login Eklenecek)")
        }

        // MAIN GRAFİĞİ
        composable(Screen.MainGraph.route) {
            Text(text = "Ana Sayfa (Discovery)")
        }
    }
}
