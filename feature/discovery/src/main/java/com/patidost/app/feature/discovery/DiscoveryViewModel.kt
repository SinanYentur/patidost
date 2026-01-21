package com.patidost.app.feature.discovery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patidost.app.domain.analytics.AnalyticsService
import com.patidost.app.domain.model.Pet
import com.patidost.app.domain.repository.PetRepository
import com.patidost.app.domain.repository.QuotaRepository
import com.patidost.app.domain.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DiscoveryUiState(
    val petStack: List<Pet> = emptyList(),
    val currentIndex: Int = 0,
    val isLoading: Boolean = false,
    val error: String? = null,
    val remainingSuperLikes: Int = 0
) {
    val currentPet: Pet? get() = petStack.getOrNull(currentIndex)
}

@HiltViewModel
class DiscoveryViewModel @Inject constructor(
    private val petRepository: PetRepository,
    private val quotaRepository: QuotaRepository,
    private val analyticsService: AnalyticsService
) : ViewModel() {

    private val _uiState = MutableStateFlow(DiscoveryUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadPets()
        observeQuota()
    }

    private fun observeQuota() {
        viewModelScope.launch {
            quotaRepository.getRemainingSuperLikes().collect { remaining ->
                _uiState.update { it.copy(remainingSuperLikes = remaining) }
            }
        }
    }

    fun loadPets() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }

            when (val result = petRepository.getPets()) {
                is Result.Success -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            petStack = result.data,
                            currentIndex = 0
                        )
                    }
                }
                is Result.Error -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.error.message
                        )
                    }
                }
                is Result.Loading -> { /* Not used */ }
            }
        }
    }

    fun onPetLiked() {
        val pet = uiState.value.currentPet ?: return
        likePetInternal(pet)
    }

    fun onPetSuperLiked() {
        val pet = uiState.value.currentPet ?: return

        viewModelScope.launch {
            when (val quotaResult = quotaRepository.consumeSuperLike()) {
                is Result.Success -> {
                    analyticsService.logEvent("discovery_pet_super_liked", mapOf("pet_id" to pet.id))
                    likePetInternal(pet) // Proceed with normal like logic after consuming quota
                }
                is Result.Error -> {
                    _uiState.update { it.copy(error = quotaResult.error.message) }
                }
                else -> {}
            }
        }
    }

    private fun likePetInternal(pet: Pet) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            analyticsService.logEvent("discovery_pet_liked", mapOf("pet_id" to pet.id))

            when (val result = petRepository.likePet(pet.id)) {
                is Result.Success -> {
                    moveToNextPet()
                }
                is Result.Error -> {
                    _uiState.update { it.copy(isLoading = false, error = result.error.message) }
                }
                 is Result.Loading -> { /* Not used */ }
            }
        }
    }

    fun onPetDisliked() {
        val pet = uiState.value.currentPet ?: return
        analyticsService.logEvent("discovery_pet_disliked", mapOf("pet_id" to pet.id))
        moveToNextPet()
    }
    
    fun onErrorShown() {
        _uiState.update { it.copy(error = null) }
    }

    private fun moveToNextPet() {
        _uiState.update {
            val nextIndex = it.currentIndex + 1
            if (nextIndex >= it.petStack.size) {
                it.copy(currentIndex = 0, isLoading = false) // Loop for now
            } else {
                it.copy(currentIndex = nextIndex, isLoading = false)
            }
        }
    }
}
