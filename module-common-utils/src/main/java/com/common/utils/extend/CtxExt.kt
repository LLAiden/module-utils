package com.common.utils.extend

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.lifecycleScope

val Context.VMProvider
    get() =
        (this as? ViewModelStoreOwner)?.apply {
            ViewModelProvider(this)
        }
val Context.VMStore get() = VMProvider?.viewModelStore

val Context.lifecycle get() = lifecycleOwner?.lifecycle

val Context.lifecycleOwner get() = (this as? LifecycleOwner)

val Context.lifecycleScope get() = lifecycleOwner?.lifecycleScope

fun Context.goPage(kClass: Class<out Activity>, bundle: Bundle? = null) {
    Intent(this, kClass).apply {
        bundle?.let {
            putExtras(bundle)
        }
        startActivity(this)
    }
}