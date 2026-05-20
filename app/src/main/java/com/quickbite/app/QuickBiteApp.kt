package com.quickbite.app

import android.app.Application
import com.quickbite.app.di.AppComponent
import com.quickbite.app.di.DaggerAppComponent

class QuickBiteApp : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}