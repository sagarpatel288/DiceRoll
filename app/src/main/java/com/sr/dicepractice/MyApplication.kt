package com.sr.dicepractice

import android.app.Application
import com.sr.dicepractice.appconstants.Constants.LOG_APP_NAME
import timber.log.Timber

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        Timber.d(" :$LOG_APP_NAME: MyApplication: :onCreate: ")
    }
}