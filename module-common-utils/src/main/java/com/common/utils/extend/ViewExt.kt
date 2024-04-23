package com.common.utils.extend

import android.graphics.Outline
import android.text.TextPaint
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import android.view.ViewOutlineProvider
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.common.utils.ClickUtil.isDoubleClick

fun View.click(onclick: (view: View) -> Unit) {
    addClickScale()
    setOnClickListener {
        if (!this.isDoubleClick()) {
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


fun View.roundRect(dp: Int) {
    clipToOutline = true
    outlineProvider = object : ViewOutlineProvider() {
        override fun getOutline(view: View, outline: Outline?) {
            outline?.setRoundRect(0, 0, view.measuredWidth, view.measuredHeight, dp.toFloat())
        }
    }
}

val View.oval
    get() = run {
        clipToOutline = true
        outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline?) {
                outline?.setOval(0, 0, view.measuredWidth, view.measuredHeight)
            }
        }
    }

val View.mLifecycleScope get() = context.mLifecycleScope

val View.mLifecycleOwner get() = context.mLifecycleOwner

val View.mLifecycle get() = context.mLifecycleOwner?.lifecycle

fun View.size(wid: Int? = null, hei: Int? = null) {
    layoutParams.apply {
        if (wid.isNotNull) {
            width = wid!!
        }
        if (hei.isNotNull) {
            height = hei!!
        }
        layoutParams = this
    }
}

fun TextView.icon(endResId: Int = 0, size: Int, gravity: Int) {
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


fun View.margin(left: Int? = null, top: Int? = null, right: Int? = null, bottom: Int? = null) {
    (layoutParams as? MarginLayoutParams)?.apply {
        if (left.isNotNull) {
            leftMargin = left!!
        }
        if (top.isNotNull) {
            topMargin = top!!
        }
        if (right.isNotNull) {
            rightMargin = right!!
        }
        if (bottom.isNotNull) {
            bottomMargin = bottom!!
        }
    }
}

fun TextPaint.warpText(str: String, maxWidth: Int): String {
    val measureTextWidth = measureText(str)
    if (measureTextWidth > maxWidth) {
        try {
            val tmp = str.substring(0, str.length - 2)
            return warpText("$tmp…", maxWidth)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
    return str
}


