package com.gorisse.thomas.lifecycle

import androidx.lifecycle.*
import kotlinx.coroutines.*

/**
 * Performs the given action when the lifecycle is created. If the view is already created the
 * action will be performed immediately, otherwise the action will be performed after the lifecycle
 * is next created.
 *
 * The action will only be invoked once, and any listeners will then be removed.
 */
inline fun Lifecycle.doOnCreate(crossinline action: () -> Unit) {
    if (currentState.isAtLeast(Lifecycle.State.CREATED)) {
        action()
    } else {
        addObserver(object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                removeObserver(this)
                action()
            }
        })
    }
}

/**
 * Performs the given action when this lifecycle is started. If the view is already started the
 * action will be performed immediately, otherwise the action will be performed after the lifecycle
 * is next started.
 *
 * The action will only be invoked once, and any listeners will then be removed.
 */
inline fun Lifecycle.doOnStart(crossinline action: () -> Unit) {
    if (currentState.isAtLeast(Lifecycle.State.STARTED)) {
        action()
    } else {
        addObserver(object : DefaultLifecycleObserver {
            override fun onStart(owner: LifecycleOwner) {
                removeObserver(this)
                action()
            }
        })
    }
}

/**
 * Performs the given action when this view is resumed. If the lifecycle is already resumed the
 * action will be performed immediately, otherwise the action will be performed after the lifecycle
 * is next resumed.
 *
 * The action will only be invoked once, and any listeners will then be removed.
 */
inline fun Lifecycle.doOnResume(crossinline action: () -> Unit) {
    if (currentState.isAtLeast(Lifecycle.State.RESUMED)) {
        action()
    } else {
        addObserver(object : DefaultLifecycleObserver {
            override fun onResume(owner: LifecycleOwner) {
                removeObserver(this)
                action()
            }
        })
    }
}

/**
 * Performs the given action when this lifecycle is paused. The action will be performed after the
 * lifecycle is next paused.
 *
 * The action will only be invoked once, and any listeners will then be removed.
 */
inline fun Lifecycle.doOnPause(crossinline action: () -> Unit) {
    addObserver(object : DefaultLifecycleObserver {
        override fun onPause(owner: LifecycleOwner) {
            removeObserver(this)
            action()
        }
    })
}

/**
 * Performs the given action when this view is stopped. The action will be performed after the
 * lifecycle is next stopped.
 *
 * The action will only be invoked once, and any listeners will then be removed.
 */
inline fun Lifecycle.doOnStop(crossinline action: () -> Unit) {
    addObserver(object : DefaultLifecycleObserver {
        override fun onStop(owner: LifecycleOwner) {
            removeObserver(this)
            action()
        }
    })
}

/**
 * Performs the given action when this lifecycle is destroyed. The action will be performed after
 * the lifecycle is next destroyed.
 *
 * The action will only be invoked once, and any listeners will then be removed.
 */
inline fun Lifecycle.doOnDestroy(crossinline action: () -> Unit) {
    addObserver(object : DefaultLifecycleObserver {
        override fun onDestroy(owner: LifecycleOwner) {
            removeObserver(this)
            action()
        }
    })
}

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
fun Lifecycle.observe(
    onCreate: ((owner: LifecycleOwner) -> Unit)? = null,
    onStart: ((owner: LifecycleOwner) -> Unit)? = null,
    onResume: ((owner: LifecycleOwner) -> Unit)? = null,
    onPause: ((owner: LifecycleOwner) -> Unit)? = null,
    onStop: ((owner: LifecycleOwner) -> Unit)? = null,
    onDestroy: ((owner: LifecycleOwner) -> Unit)? = null
) {
    addObserver(object : DefaultLifecycleObserver {
        override fun onCreate(owner: LifecycleOwner) {
            onCreate?.invoke(owner)
        }

        override fun onStart(owner: LifecycleOwner) {
            onStart?.invoke(owner)
        }

        override fun onResume(owner: LifecycleOwner) {
            onResume?.invoke(owner)
        }

        override fun onPause(owner: LifecycleOwner) {
            onPause?.invoke(owner)
        }

        override fun onStop(owner: LifecycleOwner) {
            onStop?.invoke(owner)
        }

        override fun onDestroy(owner: LifecycleOwner) {
            onDestroy?.invoke(owner)
        }
    })
}