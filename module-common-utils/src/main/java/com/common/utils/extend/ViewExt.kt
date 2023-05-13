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
