package com.common.utils

import android.util.Log
import android.view.View

object ClickUtil {

   private const val DEFAULT_INTERVAL_MS = 500L

    fun isDoubleClick(view: View, customIntervalMs: Long = DEFAULT_INTERVAL_MS): Boolean {
        val lastClickTimestampKey = TagUtil.generateTagId(Constants.TAG.TAG_DOUBLE_CLICK)
        val lastClickTimestamp = view.getTag(lastClickTimestampKey) as? Long ?: 0L
        val currentTime = System.currentTimeMillis()

        val isDoubleClick = currentTime - lastClickTimestamp <= customIntervalMs
        if (!isDoubleClick) {
            // Only update the tag if it's not a double click
            view.setTag(lastClickTimestampKey, currentTime)
        }
        return isDoubleClick
    }
}
