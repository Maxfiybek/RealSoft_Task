package com.example.realsofttask.ui.screens.login

import com.example.realsofttask.domain.models.local.UserUiModel

data class LoginState(
    val token: String = "",
    val gmail: String = "",
    val password: String = "",
    val user: UserUiModel = UserUiModel(fullName = "", userAvatar = "", userId = 0)
)
