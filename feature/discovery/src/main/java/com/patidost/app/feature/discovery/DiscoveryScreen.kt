package com.patidost.app.feature.discovery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.patidost.app.domain.model.Pet
import com.patidost.app.feature.discovery.R

@Composable
fun DiscoveryScreen(viewModel: DiscoveryViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when {
            uiState.isLoading -> {
                CircularProgressIndicator()
            }
            uiState.error != null -> {
                Text(text = "Error: ${uiState.error}", color = Color.Red)
            }
            uiState.currentPet != null -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    PetCard(pet = uiState.currentPet!!, modifier = Modifier.weight(1f))
                    Spacer(modifier = Modifier.height(16.dp))
                    ActionButtons(
                        onDislike = { viewModel.onPetDisliked() },
                        onLike = { viewModel.onPetLiked() }
                    )
                }
            }
            else -> {
                Text(stringResource(id = R.string.discovery_no_more_pets))
            }
        }
    }
}

@Composable
private fun ActionButtons(onDislike: () -> Unit, onLike: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = onDislike) {
            Icon(Icons.Default.Close, contentDescription = stringResource(id = R.string.discovery_dislike_button_content_description))
        }
        Button(onClick = onLike) {
            Icon(Icons.Default.Favorite, contentDescription = stringResource(id = R.string.discovery_like_button_content_description))
        }
    }
}

@Preview(showBackground = true, name = "Discovery Screen - Content")
@Composable
private fun DiscoveryScreenPreview_Content() {
    val samplePet = Pet(
        id = "1",
        name = "Sımon",
        breed = "Golden Retriever",
        age = 2,
        imageUrl = "https://example.com/simon.jpg",
        location = "Istanbul, Turkey"
    )
    Column(modifier = Modifier.fillMaxSize()) {
        PetCard(pet = samplePet, modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.height(16.dp))
        ActionButtons(onDislike = {}, onLike = {})
    }
}

@Preview(showBackground = true, name = "Discovery Screen - Loading")
@Composable
private fun DiscoveryScreenPreview_Loading() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Preview(showBackground = true, name = "Discovery Screen - Error")
@Composable
private fun DiscoveryScreenPreview_Error() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Error: Something went wrong", color = Color.Red)
    }
}
