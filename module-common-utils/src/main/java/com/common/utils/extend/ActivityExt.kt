package com.common.utils.extend

import android.app.Activity

val Activity.isValid: Boolean
    get() = !isFinishing && !isDestroyed