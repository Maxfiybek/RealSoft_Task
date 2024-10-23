package com.example.realsofttask.ui.screens.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.realsofttask.common.viewModel.BaseViewModel
import com.example.realsofttask.data.network.AppRepository
import com.example.realsofttask.domain.mapper.mapToUiModel
import com.example.realsofttask.utils.extensions.resultOf
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: AppRepository
) : BaseViewModel<HomeState, Unit>(HomeState()) {

    init {
        getTasks()
    }

    private fun getTasks() {
        viewModelScope.launch {
            resultOf {
                repository.getTasks()
            }.onSuccess { items ->
                println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS")
                Log.d("Success getTasks", "::: $items")
                mutableState.update { it.copy(tasks = items.map { it.mapToUiModel() }) }
                mutableState.update { it.copy(dto = items) }
            }.onFailure {
                Log.d("Error getTasks", "::: ${it.message}")
            }
        }
    }
}