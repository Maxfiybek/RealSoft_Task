package com.example.realsofttask.domain.models.remote.login


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginReqDto(
    @SerialName("login")
    val login: String,
    @SerialName("password")
    val password: String
)