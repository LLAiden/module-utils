package com.common.utils.extend

import android.text.format.DateFormat
import androidx.annotation.IntRange
import com.common.utils.ColorUtil
import com.common.utils.ScreenUtil
import java.text.NumberFormat
import java.util.Locale

val Int.dp get() = ScreenUtil.dp2px(this.toFloat())

val Int.fdp get() = ScreenUtil.dp2px(this.toFloat()).toFloat()
val Float.dp get() = ScreenUtil.dp2px(this)
fun Int.alpha(@IntRange(from = 1, to = 100) value: Int) = ColorUtil.alphaColor(this, value)

fun Int.rtl(size: Int, isRTL: Boolean = ScreenUtil.isRTL()): Int {
    return if (isRTL) {
        size - 1 - this
    } else this
}

/**
 * 百分比
 */
private val percentFormat: NumberFormat = NumberFormat.getPercentInstance()
fun Double.percentage(): String {
    return percentFormat.format(this)
}

fun Float.percentage(): String {
    return percentFormat.format(this)
}

/**
 * 123456789
 * 输出：123,456,789
 */
fun Number.delimiter(locale: Locale = Locale.getDefault()): String {
    val formatter = NumberFormat.getInstance(locale).apply {
        isGroupingUsed = true
    }
    return formatter.format(this)
}

fun Long.dateTime(formatPattern: String = "yyyy-MM-dd"): String {
    return DateFormat.format(formatPattern, this).toString()
}