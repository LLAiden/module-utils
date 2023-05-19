package com.common.utils.extend

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
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

fun Context.goPage(kClass: Class<out Activity>, bundle: Bundle? = null) {
    Intent(this, kClass).apply {
        bundle?.let {
            putExtras(bundle)
        }
        startActivity(this)
    }
}