package com.example.realsofttask.ui.screens.home

import com.example.realsofttask.domain.models.local.TaskUiModel
import com.example.realsofttask.domain.models.remote.task.TaskResDto

data class HomeState(
    val tasks: List<TaskUiModel> = emptyList(),
    val dto: List<TaskResDto> = emptyList(),
)
