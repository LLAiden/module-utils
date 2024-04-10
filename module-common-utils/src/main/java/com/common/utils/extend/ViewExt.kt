package com.common.utils.extend

import android.graphics.Outline
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import android.view.ViewOutlineProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import com.common.utils.ClickUtil

fun View.click(onclick: (view: View) -> Unit) {
    addClickScale()
    setOnClickListener {
        if (!ClickUtil.isDoubleClick(view = this)) {
            onclick.invoke(this)
        }
    }
}

fun View.addClickScale(scale: Float = 0.95f, duration: Long = 100) {
    this.setOnTouchListener { _, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                animate().scaleX(scale).scaleY(scale).setDuration(duration).start()
            }
            MotionEvent.ACTION_UP -> {
                animate().scaleX(1f).scaleY(1f).setDuration(duration).start()
                this.performClick()
            }
            MotionEvent.ACTION_CANCEL -> {
                animate().scaleX(1f).scaleY(1f).setDuration(duration).start()
            }
        }
        true
    }
}


fun View.toRoundRect(dp: Int) {
    clipToOutline = true
    outlineProvider = object : ViewOutlineProvider() {
        override fun getOutline(view: View, outline: Outline?) {
            outline?.setRoundRect(0, 0, view.measuredWidth, view.measuredHeight, dp.toFloat())
        }
    }
}

fun View.toOval() {
    clipToOutline = true
    outlineProvider = object : ViewOutlineProvider() {
        override fun getOutline(view: View, outline: Outline?) {
            outline?.setOval(0, 0, view.measuredWidth, view.measuredHeight)
        }
    }
}

fun View.getLifecycleScope(): LifecycleCoroutineScope? {
    return context.getLifecycleScope()
}

fun View.getLifecycleOwner(): LifecycleOwner? {
    return context.getLifecycleOwner()
}


fun View.getLifecycle(): Lifecycle? {
    return context.getLifecycleOwner()?.lifecycle
}

fun View.resetSize(wid: Int? = null, hei: Int? = null) {
    layoutParams.apply {
        if (wid.isNotNull()) {
            width = wid!!
        }
        if (hei.isNotNull()) {
            height = hei!!
        }
        layoutParams = this
    }
}

fun TextView.setIcon(endResId: Int = 0, size: Int, gravity: Int) {
    val drawable = ContextCompat.getDrawable(context, endResId)?.apply {
            setBounds(0, 0, size.dp, size.dp)
        }
    if (drawable != null) {
        setCompoundDrawablesRelative(
            if (gravity == Gravity.START) drawable else null,
            if (gravity == Gravity.TOP) drawable else null,
            if (gravity == Gravity.END) drawable else null,
            if (gravity == Gravity.BOTTOM) drawable else null,
        )
    } else {
        setCompoundDrawablesRelative(null, null, null, null)
    }
}


fun View.setMargin(left: Int? = null, top: Int? = null, right: Int? = null, bottom: Int? = null) {
    (layoutParams as? MarginLayoutParams)?.apply {
        if (left.isNotNull()) {
            leftMargin = left!!
        }
        if (top.isNotNull()) {
            topMargin = top!!
        }
        if (right.isNotNull()) {
            rightMargin = right!!
        }
        if (bottom.isNotNull()) {
            bottomMargin = bottom!!
        }
    }
}

fun TextPaint.getWarpText(str: String, maxWidth: Int): String {
    val measureTextWidth = measureText(str)
    if (measureTextWidth > maxWidth) {
        try {
            val tmp = str.substring(0, str.length - 2)
            return getWarpText("$tmp…", maxWidth)
        } catch (ex: Exception) {
        }
    }
    return str
}


