package com.patidost.app.core.di

import com.patidost.app.core.utils.DispatchersProvider
import com.patidost.app.core.utils.StandardDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    @Singleton
    fun provideDispatchersProvider(): DispatchersProvider {
        return StandardDispatchers()
    }
}
