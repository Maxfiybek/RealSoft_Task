package com.example.realsofttask.domain.models.local

data class TaskUiModel(
    val taskId: Int,
    val projectName: String,
    val ownerName: String,
    val ownerAvatar: String,
    val executorName: String,
    val executorAvatar: String,
    val taskDate: String,
    val termDate: String,
    val status: String,
    val name: String
)
