package com.common.utils.extend

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * 构造一个协程作用域
 * SupervisorJob 子协程取消不会取消同级协程
 * Job  修改为将将取消同级协程
 */
fun mCoroutineScope(context: CoroutineContext = Dispatchers.Main + Job()): CoroutineScope {
    return CoroutineScope(context)
}

fun Any.launch(context: CoroutineContext = Dispatchers.Main + Job(), block: suspend CoroutineScope.() -> Unit): Job {
    val scope = when (this) {
        is ViewModel -> viewModelScope
        is LifecycleOwner -> lifecycleScope
        else -> mCoroutineScope()
    }
    return scope.launch(context) { block() }
}

val Any?.isNotNull get() = this != null
