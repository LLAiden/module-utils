package com.common.utils.extend

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.lifecycleScope

val Context.VMProvider: ViewModelStoreOwner?
    get() =
        (this as? ViewModelStoreOwner)?.apply {
            ViewModelProvider(this)
        }

val Context.VMStore: ViewModelStore?
    get() = VMProvider?.viewModelStore

val Context.lifecycle: Lifecycle?
    get() = lifecycleOwner?.lifecycle


val Context.lifecycleOwner: LifecycleOwner?
    get() = (this as? LifecycleOwner)

val Context.lifecycleScope: LifecycleCoroutineScope?
    get() = lifecycleOwner?.lifecycleScope

fun Context.goPage(kClass: Class<out Activity>, bundle: Bundle? = null) {
    Intent(this, kClass).apply {
        bundle?.let {
            putExtras(bundle)
        }
        startActivity(this)
    }
}