package com.example.realsofttask.ui.screens.home

interface HomeEvent {
    data object Error : HomeEvent
    data object Loading : HomeEvent
    data object Success : HomeEvent
}