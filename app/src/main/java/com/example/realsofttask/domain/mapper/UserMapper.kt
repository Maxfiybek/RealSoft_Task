package com.example.realsofttask.domain.mapper

import com.example.realsofttask.domain.models.local.UserUiModel
import com.example.realsofttask.domain.models.remote.login.LoginResDto

fun LoginResDto.UserDto.mapToUiModel() =
    UserUiModel(fullName = fullName, userAvatar = avatar, userId = userId)