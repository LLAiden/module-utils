package com.aiden.moduleutils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.common.utils.container.AppContainer
import com.common.utils.extend.showToast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppContainer.initApp(application)
        "toast".showToast


    }
}