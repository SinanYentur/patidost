package com.patidost.app.data.di

import com.patidost.app.data.analytics.LogcatAnalyticsService
import com.patidost.app.domain.analytics.AnalyticsService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Hilt module for providing the [AnalyticsService] dependency.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class AnalyticsModule {

    @Binds
    abstract fun bindAnalyticsService(
        logcatAnalyticsService: LogcatAnalyticsService
    ): AnalyticsService
}
