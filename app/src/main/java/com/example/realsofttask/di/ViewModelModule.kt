package com.example.realsofttask.di

import com.example.realsofttask.ui.screens.home.HomeViewModel
import com.example.realsofttask.ui.screens.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::LoginViewModel)
    viewModelOf(::HomeViewModel)
}