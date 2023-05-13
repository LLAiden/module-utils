package com.common.utils

import android.content.Context
import android.content.res.Resources

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
}