package com.patidost.app.data.analytics

import com.patidost.app.domain.analytics.AnalyticsService
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * A concrete implementation of [AnalyticsService] that logs events to Logcat via Timber.
 * This serves as the initial, testable implementation for the analytics infrastructure.
 */
@Singleton
class LogcatAnalyticsService @Inject constructor() : AnalyticsService {

    override fun logEvent(name: String, params: Map<String, Any>) {
        // Using a dedicated tag for easy filtering in Logcat.
        Timber.tag("PatiDostAnalytics").d("Event: '$name', Params: $params")
    }
}
