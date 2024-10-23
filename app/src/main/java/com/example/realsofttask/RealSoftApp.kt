package com.example.realsofttask

import android.app.Application
import com.example.realsofttask.di.dataBaseModule
import com.example.realsofttask.di.networkModule
import com.example.realsofttask.di.repositoryModule
import com.example.realsofttask.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class RealSoftApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RealSoftApp)
            modules(networkModule)
            modules(repositoryModule)
            modules(dataBaseModule)
            modules(viewModelModule)
        }
    }
}