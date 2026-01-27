package com.patidost.core.data.di

import com.patidost.core.data.repository.MockAuthRepository
import com.patidost.core.data.repository.MockDiscoveryRepository
import com.patidost.core.domain.repository.AuthRepository
import com.patidost.core.domain.repository.DiscoveryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindAuthRepository(
        impl: MockAuthRepository
    ): AuthRepository

    @Binds
    abstract fun bindDiscoveryRepository(
        impl: MockDiscoveryRepository
    ): DiscoveryRepository
}
