package com.common.utils.extend

import androidx.annotation.IntRange
import com.common.utils.ColorUtil
import com.common.utils.ScreenUtil

val Int.dp get() = ScreenUtil.dp2px(this.toFloat())

val Float.dp get() = ScreenUtil.dp2px(this)
fun Int.colorAlpha(@IntRange(from = 1, to = 100) value: Int) = ColorUtil.alphaColor(this, value)