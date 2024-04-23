package com.common.utils.extend

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope

val Context.mLifecycle get() = mLifecycleOwner?.lifecycle

val Context.mLifecycleOwner get() = (this as? LifecycleOwner)

val Context.mLifecycleScope get() = mLifecycleOwner?.lifecycleScope

fun Context.goPage(kClass: Class<out Activity>, bundle: Bundle? = null) {
    Intent(this, kClass).apply {
        bundle?.let {
            putExtras(bundle)
        }
        startActivity(this)
    }
}