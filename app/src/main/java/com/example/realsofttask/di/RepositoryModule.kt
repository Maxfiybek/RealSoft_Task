package com.example.realsofttask.di

import com.example.realsofttask.data.network.AppRepository
import com.example.realsofttask.data.network.AppRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::AppRepositoryImpl) bind AppRepository::class
}