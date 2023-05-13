package com.common.utils.container

import android.app.Application

object ApplicationContainer {

    private lateinit var mApplication: Application

    fun initApp(app: Application) {
        mApplication = app
    }

    fun getApp(): Application {
        return mApplication
    }
}