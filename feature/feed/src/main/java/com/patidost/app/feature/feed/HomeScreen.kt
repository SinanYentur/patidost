package com.patidost.app.feature.feed

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
// import com.patidost.app.feature.discovery.DiscoveryScreen // Marked for deletion

private sealed class BottomBarScreen(val route: String, val title: String, val icon: ImageVector) {
    object Feed : BottomBarScreen("feed", "Feed", Icons.Default.Home)
    object Discovery : BottomBarScreen("discovery", "Discovery", Icons.Default.Search)
}

private val items = listOf(
    BottomBarScreen.Feed,
    BottomBarScreen.Discovery,
)

@Composable
fun HomeScreen() {
    var selectedRoute by remember { mutableStateOf(BottomBarScreen.Feed.route) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = screen.title) },
                        label = { Text(screen.title) },
                        selected = selectedRoute == screen.route,
                        onClick = { selectedRoute = screen.route }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when (selectedRoute) {
                BottomBarScreen.Feed.route -> {
                    Text(text = "Feed Screen Content")
                }
                BottomBarScreen.Discovery.route -> {
                    // Temporarily replaced to isolate the build error
                    Text(text = "Discovery Screen Placeholder")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
