package com.patidost.app.feature.economy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patidost.app.domain.repository.QuotaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EconomyViewModel @Inject constructor(
    private val quotaRepository: QuotaRepository
) : ViewModel() {

    // Kalan hakları anlık izliyoruz
    val remainingLikes: StateFlow<Int> = quotaRepository.getRemainingSuperLikes()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = 3
        )

    fun onRefreshClicked() {
        viewModelScope.launch {
            quotaRepository.refreshQuotaIfNeeded()
        }
    }
}
