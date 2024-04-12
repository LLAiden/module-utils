package com.common.utils

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.common.utils.container.AppContainer

object ToastUtil {

    @Volatile
    private var mToast: Toast? = null

    @Volatile
    private var mHandler: Handler? = null

    private val mLockAny = Any()

    fun showShort(charSequence: CharSequence, context: Context? = AppContainer.getApp) {
        context?.let {
            val applicationContext = context.applicationContext
            checkToastInstance(applicationContext, Toast.LENGTH_SHORT)
            mToast
        }?.apply {
            if (AppContainer.isMainThread) {
                mToast?.setText(charSequence)
                show()
            } else {
                checkHandlerInstance()
                mHandler?.post {
                    mToast?.setText(charSequence)
                    show()
                }
            }
        }
    }

    fun showLong(charSequence: CharSequence, context: Context? = AppContainer.getApp) {
        context?.let {
            val applicationContext = context.applicationContext
            checkToastInstance(applicationContext, Toast.LENGTH_LONG)
            mToast
        }?.apply {
            if (AppContainer.isMainThread) {
                mToast?.setText(charSequence)
                show()
            } else {
                checkHandlerInstance()
                mHandler?.post {
                    mToast?.setText(charSequence)
                    show()
                }
            }
        }
    }

    fun checkToastInstance(context: Context, duration: Int) {
        if (mToast == null) {
            synchronized(mLockAny) {
                if (mToast == null) {
                    mToast = Toast.makeText(context, null, duration)
                }
            }
        }
        mToast?.duration = duration
    }

    private fun checkHandlerInstance() {
        if (mHandler == null) {
            synchronized(mLockAny) {
                if (mHandler == null) {
                    mHandler = Handler(Looper.getMainLooper())
                }
            }
        }
    }
}