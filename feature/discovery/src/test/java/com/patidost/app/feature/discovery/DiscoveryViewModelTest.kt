package com.patidost.app.feature.discovery

import com.patidost.app.domain.analytics.AnalyticsService
import com.patidost.app.domain.model.Pet
import com.patidost.app.domain.repository.PetRepository
import com.patidost.app.domain.repository.QuotaRepository
import com.patidost.app.domain.utils.AppError
import com.patidost.app.domain.utils.Result
import com.patidost.app.test.rules.MainDispatcherRule
import io.mockk.any
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class DiscoveryViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var petRepository: PetRepository
    private lateinit var analyticsService: AnalyticsService
    private lateinit var quotaRepository: QuotaRepository

    private lateinit var viewModel: DiscoveryViewModel

    private val samplePetList = listOf(
        Pet("1", "Sımon", "Golden Retriever", 2, "url1", "Istanbul"),
        Pet("2", "Luna", "Siberian Husky", 3, "url2", "Ankara")
    )

    @Before
    fun setUp() {
        petRepository = mockk(relaxed = true)
        analyticsService = mockk(relaxed = true)
        quotaRepository = mockk(relaxed = true)
        coEvery { quotaRepository.getRemainingSuperLikes() } returns MutableStateFlow(3)
        viewModel = DiscoveryViewModel(petRepository, quotaRepository, analyticsService)
    }

    @Test
    fun `loadPets - basarili oldugunda - uiState dogru sekilde guncellenmeli`() = runTest {
        coEvery { petRepository.getPets() } returns Result.Success(samplePetList)
        viewModel.loadPets()
        advanceUntilIdle()
        val uiState = viewModel.uiState.value
        assertEquals(false, uiState.isLoading)
        assertEquals(samplePetList, uiState.petStack)
        assertEquals(0, uiState.currentIndex)
        assertNull(uiState.error)
        assertEquals(3, uiState.remainingSuperLikes)
    }

    @Test
    fun `loadPets - hata oldugunda - error durumu ayarlanmali`() = runTest {
        val errorMessage = "Network error"
        coEvery { petRepository.getPets() } returns Result.Error(AppError.NetworkError(errorMessage))
        viewModel.loadPets()
        advanceUntilIdle()
        val uiState = viewModel.uiState.value
        assertEquals(false, uiState.isLoading)
        assertEquals(errorMessage, uiState.error)
        assertEquals(true, uiState.petStack.isEmpty())
    }

    @Test
    fun `onPetLiked - cagrildiginda - repository ve analytics tetiklenmeli`() = runTest {
        coEvery { petRepository.getPets() } returns Result.Success(samplePetList)
        coEvery { petRepository.likePet(any()) } returns Result.Success(Unit)
        viewModel.loadPets()
        advanceUntilIdle()
        val currentPet = viewModel.uiState.value.currentPet!!

        viewModel.onPetLiked()
        advanceUntilIdle()

        coVerify(exactly = 1) { petRepository.likePet(currentPet.id) }
        coVerify(exactly = 1) { analyticsService.logEvent("discovery_pet_liked", mapOf("pet_id" to currentPet.id)) }

        assertEquals(1, viewModel.uiState.value.currentIndex)
    }

    @Test
    fun `onPetSuperLiked - kota varken - kota tuketilmeli ve begeni yapilmali`() = runTest {
        coEvery { petRepository.getPets() } returns Result.Success(samplePetList)
        coEvery { quotaRepository.consumeSuperLike() } returns Result.Success(Unit)
        coEvery { petRepository.likePet(any()) } returns Result.Success(Unit)
        viewModel.loadPets()
        advanceUntilIdle()
        val currentPet = viewModel.uiState.value.currentPet!!

        viewModel.onPetSuperLiked()
        advanceUntilIdle()

        coVerify(exactly = 1) { quotaRepository.consumeSuperLike() }
        coVerify(exactly = 1) { analyticsService.logEvent("discovery_pet_super_liked", mapOf("pet_id" to currentPet.id)) }
        coVerify(exactly = 1) { petRepository.likePet(currentPet.id) }

        assertEquals(1, viewModel.uiState.value.currentIndex)
    }

    @Test
    fun `onPetSuperLiked - kota yokken - hata gosterilmeli`() = runTest {
        val errorMessage = "Haftalık Super Like hakkınız doldu."
        coEvery { petRepository.getPets() } returns Result.Success(samplePetList)
        coEvery { quotaRepository.consumeSuperLike() } returns Result.Error(AppError.DatabaseError(errorMessage))
        viewModel.loadPets()
        advanceUntilIdle()

        viewModel.onPetSuperLiked()
        advanceUntilIdle()

        coVerify(exactly = 1) { quotaRepository.consumeSuperLike() }
        coVerify(exactly = 0) { analyticsService.logEvent(any(), any()) }
        coVerify(exactly = 0) { petRepository.likePet(any()) }
        assertEquals(errorMessage, viewModel.uiState.value.error)
    }
}
