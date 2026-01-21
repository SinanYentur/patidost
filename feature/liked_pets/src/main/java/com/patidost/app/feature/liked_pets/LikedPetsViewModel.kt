package com.patidost.app.feature.liked_pets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patidost.app.domain.model.Pet
import com.patidost.app.domain.repository.PetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

data class LikedPetsUiState(
    val likedPets: List<Pet> = emptyList(),
    val isLoading: Boolean = true // Initially loading
)

@HiltViewModel
class LikedPetsViewModel @Inject constructor(
    petRepository: PetRepository
) : ViewModel() {

    // This is a simple implementation that directly converts the Flow to a StateFlow.
    // In a more complex app, you might add a .map{} to create a more specific UiState.
    val uiState: StateFlow<List<Pet>> = petRepository.getLikedPets()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
}
