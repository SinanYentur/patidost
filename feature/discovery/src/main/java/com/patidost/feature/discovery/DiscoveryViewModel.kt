package com.patidost.feature.discovery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patidost.core.domain.repository.DiscoveryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiscoveryViewModel @Inject constructor(
    private val discoveryRepository: DiscoveryRepository
) : ViewModel() {
    
    init {
        loadPets()
    }

    private fun loadPets() {
        viewModelScope.launch {
            discoveryRepository.getPets()
        }
    }
}
