package com.patidost.app.domain.usecase

import com.patidost.app.domain.repository.PetRepository
import com.patidost.app.domain.utils.Result
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class LikePetUseCaseTest {

    private lateinit var petRepository: PetRepository
    private lateinit var likePetUseCase: LikePetUseCase

    @Before
    fun setUp() {
        petRepository = mockk()
        likePetUseCase = LikePetUseCase(petRepository)
    }

    @Test
    fun `invoke should call petRepository's likePet with correct petId`() = runTest {
        // Given
        val petId = "test-pet-123"
        coEvery { petRepository.likePet(petId) } returns Result.Success(Unit)

        // When
        likePetUseCase(petId)

        // Then
        coVerify(exactly = 1) { petRepository.likePet(petId) }
    }
}
