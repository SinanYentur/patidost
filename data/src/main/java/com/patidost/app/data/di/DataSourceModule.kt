package com.patidost.app.data.di

import com.patidost.app.data.source.remote.PetRemoteDataSource
import com.patidost.app.data.source.remote.PetRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindPetRemoteDataSource(
        impl: PetRemoteDataSourceImpl
    ): PetRemoteDataSource
}