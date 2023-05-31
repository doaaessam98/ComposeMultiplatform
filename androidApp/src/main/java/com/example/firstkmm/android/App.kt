package com.example.firstkmm.android

import android.app.Application
import com.example.firstkmm.android.di.appModule
import com.example.firstkmm.di.getSharedModules
import org.koin.core.context.startKoin

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule+getSharedModules())
        }
    }
}