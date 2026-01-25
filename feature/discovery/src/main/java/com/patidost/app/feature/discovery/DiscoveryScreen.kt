package com.patidost.app.feature.discovery

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.patidost.app.domain.model.Pet
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun DiscoveryScreen(
    viewModel: DiscoveryViewModel = hiltViewModel(),
    onPetClick: (String) -> Unit // YENİ: ID ileten parametre
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when {
            uiState.isLoading -> CircularProgressIndicator()
            uiState.error != null -> Text(text = "Error: ${uiState.error}", color = Color.Red)
            uiState.currentPet != null -> {
                DiscoveryContent(
                    pet = uiState.currentPet!!,
                    onDislike = { viewModel.onPetDisliked() },
                    onLike = { viewModel.onPetLiked() },
                    onPetClick = onPetClick // Parametreyi içeri aktarıyoruz
                )
            }
            else -> Text(stringResource(id = R.string.discovery_no_more_pets))
        }
    }
}

@Composable
private fun DiscoveryContent(
    pet: Pet,
    onDislike: () -> Unit,
    onLike: () -> Unit,
    onPetClick: (String) -> Unit // YENİ
) {
    val offsetX = remember { Animatable(0f) }
    val rotation = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()
    val density = LocalDensity.current.density
    val swipeThreshold = 300f * density

    LaunchedEffect(pet) {
        offsetX.snapTo(0f)
        rotation.snapTo(0f)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            PetCard(
                pet = pet,
                modifier = Modifier
                    .offset { IntOffset(offsetX.value.roundToInt(), 0) }
                    .graphicsLayer { rotationZ = rotation.value }
                    .pointerInput(Unit) {
                        detectDragGestures(
                            onDragEnd = {
                                scope.launch {
                                    if (offsetX.value > swipeThreshold) {
                                        offsetX.animateTo(1000f * density, tween(300))
                                        onLike()
                                    } else if (offsetX.value < -swipeThreshold) {
                                        offsetX.animateTo(-1000f * density, tween(300))
                                        onDislike()
                                    } else {
                                        offsetX.animateTo(0f, tween(300))
                                        rotation.animateTo(0f, tween(300))
                                    }
                                }
                            },
                            onDrag = { change, dragAmount ->
                                change.consume()
                                scope.launch {
                                    val newOffset = offsetX.value + dragAmount.x
                                    offsetX.snapTo(newOffset)
                                    rotation.snapTo(newOffset / 50)
                                }
                            }
                        )
                    },
                onItemClick = { onPetClick(pet.id) } // YENİ: Tıklanınca ID gönder
            )
        }

        ActionButtons(
            onDislike = {
                scope.launch {
                    offsetX.animateTo(-1000f * density, tween(300))
                    onDislike()
                }
            },
            onLike = {
                scope.launch {
                    offsetX.animateTo(1000f * density, tween(300))
                    onLike()
                }
            }
        )
    }
}

@Composable
private fun ActionButtons(onDislike: () -> Unit, onLike: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        Button(onClick = onDislike) {
            Icon(Icons.Default.Close, contentDescription = stringResource(R.string.discovery_dislike_button_content_description))
        }
        Button(onClick = onLike) {
            Icon(Icons.Default.Favorite, contentDescription = stringResource(R.string.discovery_like_button_content_description))
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun DiscoveryScreenPreview() {
    val pet = Pet(id = "1", name = "Preview Pet", breed = "Breed", age = 1, imageUrl = "", location = "Location")
    DiscoveryContent(pet = pet, onDislike = {}, onLike = {}, onPetClick = {})
}
