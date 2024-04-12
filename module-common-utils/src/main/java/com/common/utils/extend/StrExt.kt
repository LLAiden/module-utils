package com.common.utils.extend

import com.common.utils.ToastUtil

val String.showToast get() = ToastUtil.showShort(this)
