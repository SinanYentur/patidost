package com.patidost.app.feature.pet_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patidost.app.domain.model.Pet
import com.patidost.app.domain.repository.PetRepository
import com.patidost.app.domain.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PetDetailUiState(
    val pet: Pet? = null,
    val isLoading: Boolean = true,
    val error: String? = null
)

@HiltViewModel
class PetDetailViewModel @Inject constructor(
    private val petRepository: PetRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(PetDetailUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadPetDetails()
    }

    private fun loadPetDetails() {
        val petId = savedStateHandle.get<String>("petId")
        if (petId == null) {
            _uiState.update { it.copy(isLoading = false, error = "Pet ID not found.") }
            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }

            when (val result = petRepository.getPetById(petId)) {
                is Result.Success -> {
                    _uiState.update { it.copy(isLoading = false, pet = result.data) }
                }
                is Result.Error -> {
                    _uiState.update { it.copy(isLoading = false, error = result.error.message) }
                }
                is Result.Loading -> { /* Handled by initial isLoading update */ }
            }
        }
    }
}
