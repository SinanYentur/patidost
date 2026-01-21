package com.patidost.app.feature.liked_pets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.patidost.app.core.ui.components.PetListItem
import com.patidost.app.domain.model.Pet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LikedPetsScreen(
    viewModel: LikedPetsViewModel = hiltViewModel(),
    onPetClick: (String) -> Unit
) {
    val likedPets by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(id = R.string.liked_pets_title)) })
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            if (likedPets.isEmpty()) {
                Text(text = stringResource(id = R.string.liked_pets_empty_message))
            } else {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(likedPets) { pet ->
                        PetListItem(
                            pet = pet,
                            onItemClick = { onPetClick(pet.id) }
                        )
                    }
                }
            }
        }
    }
}
