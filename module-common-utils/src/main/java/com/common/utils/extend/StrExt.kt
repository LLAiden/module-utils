package com.common.utils.extend

import com.common.utils.ToastUtil

val String.showToast: Unit
    get() = ToastUtil.showShort(this)