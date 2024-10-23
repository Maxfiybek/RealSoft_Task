package com.example.realsofttask.data.network

import com.example.realsofttask.domain.models.remote.login.LoginReqDto
import com.example.realsofttask.domain.models.remote.login.LoginResDto
import com.example.realsofttask.domain.models.remote.task.TaskResDto
import com.example.realsofttask.domain.models.remote.task.TasksDto2
import com.example.realsofttask.utils.NetworkAdresses
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class AppRepositoryImpl(private val client: HttpClient) : AppRepository {
    override suspend fun login(
        email: String,
        password: String
    ): LoginResDto {
        return client
            .post(NetworkAdresses.LOGIN) {
                contentType(ContentType.Application.Json)
                setBody(LoginReqDto(login = email, password = password))
            }.body()
    }

    override suspend fun getTasks(): List<TaskResDto> =
        client.get(NetworkAdresses.TASKS).body()
}
