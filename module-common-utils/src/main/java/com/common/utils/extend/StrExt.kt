package com.common.utils.extend

import com.common.utils.ToastUtil

fun String.showToast() {
    ToastUtil.showShort(this)
}