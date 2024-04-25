package com.common.utils.drawable

import android.graphics.drawable.GradientDrawable
import com.common.utils.ScreenUtil

fun radiusDrawable(radius: Int, color: Int) = shapeDrawable {
    cornerRadius = radius.toFloat()
    solidColor = color
}

fun radiiDrawable(radius: FloatArray, color: Int) = shapeDrawable {
    cornerRadii = radius
    solidColor = color
}

fun gradientDrawable(radius: Int, sColor: Int, eColor: Int) = shapeDrawable {
    colors = intArrayOf(sColor, eColor)
    corners {
        this.radius = radius.toFloat()
    }
}

fun gradientDrawableOrientation(radius: Int, sColor: Int, eColor: Int) = shapeDrawable {
    colors = intArrayOf(sColor, eColor)
    orientation = if (ScreenUtil.isRTL) {
        GradientDrawable.Orientation.RIGHT_LEFT
    } else {
        GradientDrawable.Orientation.LEFT_RIGHT
    }
    corners {
        this.radius = radius.toFloat()
    }
}

fun gradientTopDrawable(radius: Float, sColor: Int, eColor: Int) = shapeDrawable {
    colors = intArrayOf(sColor, eColor)
    cornerRadii = floatArrayOf(radius, radius, radius, radius, 0f, 0f, 0f, 0f)
}

fun gradientDrawable(radius: FloatArray, sColor: Int, eColor: Int) = shapeDrawable {
    colors = intArrayOf(sColor, eColor)
    cornerRadii = radius
}

fun strokeDrawable(radius: Int, bColor: Int, strokeWidth: Int, storkeColor: Int) = shapeDrawable {
    cornerRadius = radius.toFloat()
    solidColor = bColor

    stroke {
        width = strokeWidth
        color = storkeColor
    }
}

fun strokeGradientDrawable(
    radius: FloatArray,
    strokeWidth: Int,
    storkeColor: Int,
    sColor: Int,
    eColor: Int
) = shapeDrawable {
    cornerRadii = radius
    colors = intArrayOf(sColor, eColor)
    orientation = if (ScreenUtil.isRTL) {
        GradientDrawable.Orientation.RIGHT_LEFT
    } else {
        GradientDrawable.Orientation.LEFT_RIGHT
    }
    stroke {
        width = strokeWidth
        color = storkeColor
    }
}

fun strokeGradientDrawableVertical(
    radius: FloatArray,
    strokeWidth: Int,
    strokeColor: Int,
    sColor: Int,
    eColor: Int
) = shapeDrawable {
    cornerRadii = radius
    colors = intArrayOf(sColor, eColor)
    orientation = GradientDrawable.Orientation.TOP_BOTTOM
    stroke {
        width = strokeWidth
        color = strokeColor
    }
}
