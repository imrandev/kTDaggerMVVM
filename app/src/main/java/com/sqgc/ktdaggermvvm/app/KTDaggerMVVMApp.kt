package com.sqgc.ktdaggermvvm.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KTDaggerMVVMApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}