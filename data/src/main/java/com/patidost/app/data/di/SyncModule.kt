package com.patidost.app.data.di

import com.patidost.app.data.repository.PetSyncRepositoryImpl
import com.patidost.app.domain.repository.PetSyncRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SyncModule {
    @Binds
    abstract fun bindPetSyncRepository(impl: PetSyncRepositoryImpl): PetSyncRepository
}