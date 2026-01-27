package com.patidost.feature.pet_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patidost.core.domain.repository.DiscoveryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PetDetailViewModel @Inject constructor(
    private val discoveryRepository: DiscoveryRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {
        val petId = savedStateHandle.get<String>("petId")
        if (petId != null) {
            loadPetDetail(petId)
        }
    }

    private fun loadPetDetail(id: String) {
        viewModelScope.launch {
            discoveryRepository.getPetDetail(id)
        }
    }
}
