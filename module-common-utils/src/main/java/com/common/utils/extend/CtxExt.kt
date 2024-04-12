package com.common.utils.extend

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.*

fun Context.VMProvider(): ViewModelStoreOwner? {
    return (this as? ViewModelStoreOwner)?.apply {
        ViewModelProvider(this)
    }
}

fun Context.lifecycle(): Lifecycle? {
    return lifecycleOwner()?.lifecycle
}

fun Context.lifecycleOwner(): LifecycleOwner? {
    return (this as? LifecycleOwner)
}

fun Context.getLifecycleScope(): LifecycleCoroutineScope? {
    return lifecycleOwner()?.lifecycleScope
}

fun Context.goPage(kClass: Class<out Activity>, bundle: Bundle? = null) {
    Intent(this, kClass).apply {
        bundle?.let {
            putExtras(bundle)
        }
        startActivity(this)
    }
}