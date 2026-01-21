package com.patidost.app.domain.usecase

import com.patidost.app.domain.repository.PetRepository // DEĞİŞTİ
import javax.inject.Inject

class LikePetUseCase @Inject constructor(
    private val petRepository: PetRepository // DEĞİŞTİ
) {
    suspend operator fun invoke(petId: String) = petRepository.likePet(petId)
}
