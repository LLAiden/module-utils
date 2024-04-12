package com.common.utils.extend

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/**
 * 构造一个协程作用域
 * SupervisorJob 子协程取消不会取消同级协程
 * Job  修改为将将取消同级协程
 */
fun Any.createCoroutineScope(context: CoroutineContext = Dispatchers.Main + Job()): CoroutineScope {
    return CoroutineScope(context)
}

val Any?.isNotNull: Boolean
    get() = this != null