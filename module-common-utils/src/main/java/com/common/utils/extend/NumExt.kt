package com.common.utils.extend

import androidx.annotation.IntRange
import com.common.utils.ColorUtil
import com.common.utils.ScreenUtil

val Int.dp get() = ScreenUtil.dp2px(this.toFloat())

val Int.fdp get() = ScreenUtil.dp2px(this.toFloat()).toFloat()
val Float.dp get() = ScreenUtil.dp2px(this)
fun Int.colorAlpha(@IntRange(from = 1, to = 100) value: Int) = ColorUtil.alphaColor(this, value)

fun Int.compatibleRTL(size: Int, isRTL: Boolean = ScreenUtil.isRTL()): Int {
    return if (isRTL) {
        size - 1 - this
    } else this
}