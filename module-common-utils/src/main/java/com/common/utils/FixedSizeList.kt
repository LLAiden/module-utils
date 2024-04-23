package com.common.utils

import java.util.LinkedList

class FixedSizeList<T>(private val maxSize: Int) : LinkedList<T>() {


    @Synchronized
    override fun add(element: T): Boolean {
        if (size >= maxSize){
            removeFirst()
        }
        return super.add(element)
    }
}