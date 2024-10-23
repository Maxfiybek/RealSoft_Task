package com.example.realsofttask.domain.models.remote.login


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResDto(
    @SerialName("token")
    val token: String,
    @SerialName("user")
    val userDto: UserDto
) {
    @Serializable
    data class UserDto(
        @SerialName("avatar")
        val avatar: String,
        @SerialName("full_name")
        val fullName: String,
        @SerialName("user_id")
        val userId: Int
    )
}