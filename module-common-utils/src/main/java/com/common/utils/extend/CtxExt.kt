package com.common.utils.extend

import android.content.Context
import androidx.lifecycle.*

fun Context.getViewModelProvider(): ViewModelStoreOwner? {
    return (this as? ViewModelStoreOwner)?.apply {
        ViewModelProvider(this)
    }
}

fun Context.getLifecycle(): Lifecycle? {
    return getLifecycleOwner()?.lifecycle
}

fun Context.getLifecycleOwner(): LifecycleOwner? {
    return (this as? LifecycleOwner)
}

fun Context.getLifecycleScope(): LifecycleCoroutineScope? {
    return getLifecycleOwner()?.lifecycleScope
}