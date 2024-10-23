package com.example.realsofttask.domain.mapper

import com.example.realsofttask.domain.models.local.TaskUiModel
import com.example.realsofttask.domain.models.remote.task.TaskResDto

fun TaskResDto.mapToUiModel() =
    TaskUiModel(
        taskId = taskId,
        ownerName = ownerName,
        ownerAvatar = ownerAvatar,
        executorName = executorName,
        executorAvatar = executorAvatar,
        projectName = projectName,
        taskDate = taskDate,
        termDate = termDate,
        status = status,
        name = name,
    )