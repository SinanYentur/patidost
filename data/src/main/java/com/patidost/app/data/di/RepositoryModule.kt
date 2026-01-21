package com.patidost.app.data.di

import com.patidost.app.data.repository.PetRepositoryImpl
import com.patidost.app.data.repository.QuotaRepositoryImpl
import com.patidost.app.data.repository.api.AuthRepositoryImpl
import com.patidost.app.domain.repository.AuthRepository
import com.patidost.app.domain.repository.PetRepository
import com.patidost.app.domain.repository.QuotaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindPetRepository(
        petRepositoryImpl: PetRepositoryImpl
    ): PetRepository

    @Binds
    @Singleton
    abstract fun bindQuotaRepository(
        quotaRepositoryImpl: QuotaRepositoryImpl
    ): QuotaRepository
}
