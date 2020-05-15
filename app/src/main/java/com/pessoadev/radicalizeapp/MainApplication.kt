package com.pessoadev.radicalizeapp

import android.app.Application
import com.pessoadev.radicalizeapp.di.AppModule
import com.pessoadev.radicalizeapp.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(listOf(AppModule, NetworkModule))
        }

    }
}