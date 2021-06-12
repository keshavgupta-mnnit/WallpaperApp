package com.keshav.wallpaperapp

import android.app.Application
import com.keshav.wallpaperapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WallpaperApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WallpaperApplication)
            modules(listOf(appModule))
        }
    }
}