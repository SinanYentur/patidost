package com.patidost.app.domain.analytics

/**
 * An interface for logging analytics events.
 * This decouples the application from any specific analytics implementation.
 */
interface AnalyticsService {

    /**
     * Logs a custom event.
     *
     * @param name The name of the event (e.g., "pati_puan_spent").
     * @param params A map of associated parameters (e.g., "amount" to 1, "source" to "super_like").
     */
    fun logEvent(name: String, params: Map<String, Any> = emptyMap())
}
