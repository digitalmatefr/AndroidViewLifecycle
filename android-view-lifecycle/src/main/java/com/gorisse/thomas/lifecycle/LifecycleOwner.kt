package com.gorisse.thomas.lifecycle

import androidx.lifecycle.*
import kotlinx.coroutines.*


/**
 * Performs the given action when this view is created. If the view is already created the action
 * will be performed immediately, otherwise the action will be performed after the view is next
 * created.
 *
 * The action will only be invoked once, and any listeners will then be removed.
 */
inline fun LifecycleOwner.doOnCreate(crossinline action: () -> Unit) =
    lifecycle.doOnCreate(action)

/**
 * Performs the given action when this view is started. If the view is already started the action
 * will be performed immediately, otherwise the action will be performed after the view is next
 * started.
 *
 * The action will only be invoked once, and any listeners will then be removed.
 */
inline fun LifecycleOwner.doOnStart(crossinline action: () -> Unit) =
    lifecycle.doOnStart(action)

/**
 * Performs the given action when this view is resumed. If the view is already resumed the action
 * will be performed immediately, otherwise the action will be performed after the view is next
 * resumed.
 *
 * The action will only be invoked once, and any listeners will then be removed.
 */
inline fun LifecycleOwner.doOnResume(crossinline action: () -> Unit) =
    lifecycle.doOnResume(action)

/**
 * Performs the given action when this view is paused. The action will be performed after the view
 * is next paused.
 *
 * The action will only be invoked once, and any listeners will then be removed.
 */
inline fun LifecycleOwner.doOnPause(crossinline action: () -> Unit) =
    lifecycle.doOnPause(action)

/**
 * Performs the given action when this view is stopped. The action will be performed after the view
 * is next stopped.
 *
 * The action will only be invoked once, and any listeners will then be removed.
 */
inline fun LifecycleOwner.doOnStop(crossinline action: () -> Unit) =
    lifecycle.doOnStop(action)

/**
 * Performs the given action when this view is destroyed. The action will be performed after the view
 * is next destroyed.
 *
 * The action will only be invoked once, and any listeners will then be removed.
 */
inline fun LifecycleOwner.doOnDestroy(crossinline action: () -> Unit) =
    lifecycle.doOnDestroy(action)

/**
 * ### Adds a LifecycleObserver that will be notified when the LifecycleOwner changes state
 *
 * The given observer will be brought to the current state of the LifecycleOwner.
 * For example, if the LifecycleOwner is in [State.STARTED] state, the given observer
 * will receive [Event.ON_CREATE], [Event.ON_START] events.
 *
 * @param onCreate Notifies that {@code ON_CREATE} event occurred.
 * This method will be called after the {@link LifecycleOwner}'s {@code onCreate} method returns.
 * @param onStart Notifies that {@code ON_START} event occurred.
 * This method will be called after the {@link LifecycleOwner}'s {@code onStart} method returns.
 * @param onResume Notifies that {@code ON_RESUME} event occurred.
 * This method will be called after the {@link LifecycleOwner}'s {@code onResume} method returns.
 * @param onPause Notifies that {@code ON_PAUSE} event occurred.
 * This method will be called before the {@link LifecycleOwner}'s {@code onPause} method
 * is called.
 * @param onStop Notifies that {@code ON_STOP} event occurred.
 * This method will be called before the {@link LifecycleOwner}'s {@code onStop} method
 * is called.
 * @param onDestroy Notifies that {@code ON_DESTROY} event occurred.
 * This method will be called before the {@link LifecycleOwner}'s {@code onDestroy} method
 * is called.
 */
fun LifecycleOwner.observe(
    onCreate: ((owner: LifecycleOwner) -> Unit)? = null,
    onStart: ((owner: LifecycleOwner) -> Unit)? = null,
    onResume: ((owner: LifecycleOwner) -> Unit)? = null,
    onPause: ((owner: LifecycleOwner) -> Unit)? = null,
    onStop: ((owner: LifecycleOwner) -> Unit)? = null,
    onDestroy: ((owner: LifecycleOwner) -> Unit)? = null
) = lifecycle.observe(onCreate, onStart, onResume, onPause, onStop, onDestroy)