package com.common.utils.container

import android.app.Application
import android.os.Looper
import android.widget.Toast
import com.common.utils.ToastUtil

object AppContainer {

    private lateinit var mApplication: Application

    fun initApp(app: Application) {
        if (isMainThread) {
            mApplication = app
            ToastUtil.checkToastInstance(mApplication, Toast.LENGTH_SHORT)
        } else {
            throw IllegalStateException("ApplicationContainer must be init in main thread")
        }
    }

    val getApp: Application
        get() = mApplication

    val isMainThread: Boolean
        get() = Looper.getMainLooper() == Looper.myLooper()
}