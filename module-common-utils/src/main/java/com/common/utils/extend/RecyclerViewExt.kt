package com.common.utils.extend

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.addItemDecoration(leftDp: Int = 0, topDp: Int = 0, rightDp: Int = 0, bottomDp: Int = 0): RecyclerView {
    removeItemDecoration()
    addItemDecoration(createItemDecoration(leftDp, topDp, rightDp, bottomDp))
    return this
}

fun RecyclerView.removeItemDecoration() {
    for (index in 0 until itemDecorationCount) {
        val itemDecoration = getItemDecorationAt(index)
        removeItemDecoration(itemDecoration)
    }
}

fun createItemDecoration(leftDp: Int = 0, topDp: Int = 0, rightDp: Int = 0, bottomDp: Int = 0): RecyclerView.ItemDecoration {
    return object : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            super.getItemOffsets(outRect, view, parent, state)
            outRect.left = leftDp.dp
            outRect.top = topDp.dp
            outRect.right = rightDp.dp
            outRect.bottom = bottomDp.dp
        }
    }
}