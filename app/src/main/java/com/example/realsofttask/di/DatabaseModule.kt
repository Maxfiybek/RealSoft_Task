package com.example.realsofttask.di

import android.content.Context
import androidx.room.Room
import com.example.realsofttask.data.dataBase.AppDataBase
import com.example.realsofttask.utils.DataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataBaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDataBase::class.java,
            DataBase.NAME
        ).fallbackToDestructiveMigration().build()
    }
    single {
        get<AppDataBase>().appDao()
    }

    single {
        androidApplication().getSharedPreferences("apa_preference", Context.MODE_PRIVATE)
    }

}