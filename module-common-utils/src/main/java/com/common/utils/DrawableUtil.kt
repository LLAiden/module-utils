package com.common.utils

import android.content.Context
import android.graphics.drawable.GradientDrawable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.Size
import androidx.core.content.ContextCompat

object DrawableUtil {

    fun getGradientDrawable(
        @ColorInt color: Int, radius: Float, graph: Int = GradientDrawable.RECTANGLE
    ): GradientDrawable {
        return GradientDrawable().apply {
            shape = graph
            setColor(color)
            cornerRadius = radius
        }
    }

    fun getGradientDrawable(
        context: Context,
        @ColorRes color: Int,
        radius: Float,
        graph: Int = GradientDrawable.RECTANGLE
    ): GradientDrawable {
        return getGradientDrawable(ContextCompat.getColor(context, color), radius, graph)
    }


    fun getGradientDrawable(
        @ColorInt color: Int, @Size(4) radius: FloatArray, graph: Int = GradientDrawable.RECTANGLE
    ): GradientDrawable {
        return GradientDrawable().apply {
            shape = graph
            setColor(color)
            val radiusList = floatArrayOf(
                radius[0],
                radius[0],
                radius[1],
                radius[1],
                radius[2],
                radius[2],
                radius[3],
                radius[3]
            )
            this.cornerRadii = radiusList
        }
    }


    fun getGradientDrawable(
        context: Context,
        @ColorRes color: Int,
        @Size(4) radius: FloatArray,
        graph: Int = GradientDrawable.RECTANGLE
    ): GradientDrawable {
        return getGradientDrawable(ContextCompat.getColor(context, color), radius, graph)
    }


    fun GradientDrawable.setStrokeDrawable(width: Int, color: Int) {
        setStroke(width, color)
    }

    fun GradientDrawable.setGradientDrawable(
        drawable: GradientDrawable,
        colors: IntArray,
        gradientType: Int = GradientDrawable.LINEAR_GRADIENT
    ) {
        drawable.apply {
            drawable.gradientType = gradientType
            drawable.colors = colors
        }
    }
}