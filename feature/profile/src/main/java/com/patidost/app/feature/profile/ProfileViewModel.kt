package com.patidost.app.feature.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patidost.app.domain.model.User
import com.patidost.app.domain.repository.AuthRepository
import com.patidost.app.domain.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ProfileUiState(
    val user: User? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val isLoggedOut: Boolean = false
)

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadCurrentUser()
    }

    private fun loadCurrentUser() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            when (val result = authRepository.getCurrentUser()) {
                is Result.Success -> {
                    _uiState.update { it.copy(isLoading = false, user = result.data) }
                }
                is Result.Error -> {
                    // Standart 1: Hata kaynağını şeffaf bir şekilde UI katmanına ilet
                    _uiState.update { it.copy(isLoading = false, error = result.error.message) }
                }
                else -> { _uiState.update { it.copy(isLoading = false) } }
            }
        }
    }

    fun onBioChanged(newBio: String) {
        _uiState.value.user?.let {
            updateProfile(it.copy(bio = newBio))
        }
    }

    private fun updateProfile(user: User) {
        viewModelScope.launch {
            // Standart 2: Optimistic Update - Kullanıcıyı bekletme, UI'ı hemen güncelle
            val originalUser = _uiState.value.user
            _uiState.update { it.copy(user = user, isLoading = true, error = null) }

            when (val result = authRepository.updateUserProfile(user)) {
                is Result.Success -> {
                    _uiState.update { it.copy(isLoading = false) }
                }
                is Result.Error -> {
                    // Standart 3: Resilience - Hata anında veriyi eski haline çek (Rollback)
                    _uiState.update { 
                        it.copy(
                            user = originalUser, 
                            isLoading = false, 
                            error = result.error.message // Kara kutu kırıldı: Gerçek hata mesajı iletiliyor
                        ) 
                    }
                }
                else -> { _uiState.update { it.copy(isLoading = false) } }
            }
        }
    }

    fun onLogoutClicked() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            when (val result = authRepository.logout()) {
                is Result.Success -> {
                    _uiState.update { it.copy(isLoading = false, isLoggedOut = true) }
                }
                is Result.Error -> {
                    // Şeffaf Hata Yönetimi: Sabit metin yerine gerçek AppError mesajı
                    _uiState.update { 
                        it.copy(
                            isLoading = false, 
                            error = result.error.message 
                        ) 
                    }
                }
                else -> { _uiState.update { it.copy(isLoading = false) } }
            }
        }
    }

    fun onNavigationDone() {
        _uiState.update { it.copy(isLoggedOut = false) }
    }
}
