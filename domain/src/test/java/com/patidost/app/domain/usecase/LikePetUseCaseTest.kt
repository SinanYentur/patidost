package com.patidost.app.domain.usecase

import com.patidost.app.domain.repository.UserRepository
import com.patidost.app.domain.utils.Result
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class LikePetUseCaseTest {

    private lateinit var userRepository: UserRepository
    private lateinit var likePetUseCase: LikePetUseCase

    @Before
    fun setUp() {
        userRepository = mockk()
        likePetUseCase = LikePetUseCase(userRepository)
    }

    @Test
    fun `invoke should call userRepository's likePet with correct petId`() = runTest {
        // Given
        val petId = "test-pet-123"
        coEvery { userRepository.likePet(petId) } returns Result.Success(Unit)

        // When
        likePetUseCase(petId)

        // Then
        coVerify(exactly = 1) { userRepository.likePet(petId) }
    }
}
