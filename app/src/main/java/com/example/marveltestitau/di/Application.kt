package com.example.marveltestitau.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@Application)
            modules(
                listOf(
                    viewModelModule,
                    useCaseModule,
                    repositoryModule,
                    datasourceModule,
                    networkModule
                )
            )
        }
    }
}