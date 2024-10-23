package com.example.realsofttask.ui.screens.login

import com.example.realsofttask.domain.models.local.UserUiModel

sealed interface LoginEvents {
    object Loading : LoginEvents
    data class Success(val successMessage: UserUiModel) : LoginEvents
    data class Error(val message: String) : LoginEvents
}