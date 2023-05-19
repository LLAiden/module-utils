package com.common.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import com.common.utils.container.ApplicationContainer

object ScreenUtil {
    fun getScreenWidth(context: Context): Int {
        return context.resources.displayMetrics.widthPixels
    }

    fun getScreenHeight(context: Context): Int {
        return context.resources.displayMetrics.heightPixels
    }


    fun dp2px(dpValue: Float): Int {
        return (0.5f + dpValue * Resources.getSystem().displayMetrics.density).toInt()
    }

    fun px2dp(pxValue: Int): Float {
        return pxValue / Resources.getSystem().displayMetrics.density
    }

    @SuppressLint("InternalInsetResource")
    fun getStatusBarHeight(context: Context): Int {
        val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
        return context.resources.getDimensionPixelSize(resourceId)
    }

    @SuppressLint("InternalInsetResource", "DiscouragedApi")
    fun getStatusBarHeight(): Int {
        val application = ApplicationContainer.getApp()
        val resourceId: Int = application.resources
            .getIdentifier("status_bar_height", "dimen", "android")
        return application.resources.getDimensionPixelSize(resourceId)
    }

    fun sp2px(spValue: Float): Int {
        val fontScale: Float = Resources.getSystem().displayMetrics.scaledDensity
        return (spValue * fontScale + 0.5f).toInt()
    }
}