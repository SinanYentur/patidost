package com.patidost.app.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patidost.app.core.utils.DispatchersProvider
import com.patidost.app.domain.utils.AppError
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * The heart of the MVI architecture for this project. It enforces UDF and fault-tolerance.
 *
 * - Designed with "Second-Order Thinking": Considers future maintenance and developer errors.
 * - Abuse-Case Ready: Event handling is designed to prevent common UI bugs like repeated actions.
 * - Testable from Birth: Requires a [DispatchersProvider] for reliable testing.
 * - Evolution-Aware: Built to be extended, not broken.
 *
 * @param State The immutable data class representing the UI state.
 * @param Event A sealed class representing one-time UI events (e.g., navigation, toasts).
 */
abstract class BaseViewModel<State : Any, Event : Any>(
    private val dispatchersProvider: DispatchersProvider
) : ViewModel() {

    protected abstract fun createInitialState(): State

    private val initialState: State by lazy { createInitialState() }

    private val _uiState = MutableStateFlow(initialState)
    val uiState = _uiState.asStateFlow()

    private val _event = MutableSharedFlow<Event>(
        replay = 0, // CRITICAL: Ensures events are one-shot, preventing "zombie events" on configuration change.
        extraBufferCapacity = 64,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val event = _event.asSharedFlow()

    /**
     * Safely updates the UI state. This is the only way to mutate the state.
     */
    protected fun setState(reduce: State.() -> State) {
        _uiState.update(reduce)
    }

    /**
     * Safely sends a one-time event to the UI layer. This is non-suspending for easy invocation from UI listeners.
     */
    protected fun sendEvent(event: Event) {
        viewModelScope.launch(dispatchersProvider.main) {
            _event.emit(event)
        }
    }

    /**
     * The final safety net. It catches unexpected exceptions from `safeLaunch` blocks.
     * Subclasses must define how to translate a raw [AppError] into a user-facing event or state.
     */
    protected abstract fun handleGeneralError(error: AppError)

    /**
     * The primary way to launch coroutines for data operations.
     * It uses the I/O dispatcher and wraps the block in a try-catch to enforce fault-tolerance.
     */
    protected fun safeLaunch(block: suspend () -> Unit) {
        viewModelScope.launch(dispatchersProvider.io) {
            try {
                block()
            } catch (e: Exception) {
                handleGeneralError(AppError.UnknownError(e))
            }
        }
    }
}
