package com.example.realsofttask.data.network

import com.example.realsofttask.domain.models.remote.login.LoginResDto
import com.example.realsofttask.domain.models.remote.task.TaskResDto

interface AppRepository {
    suspend fun login(email: String, password: String): LoginResDto
    suspend fun getTasks(): List<TaskResDto>
}