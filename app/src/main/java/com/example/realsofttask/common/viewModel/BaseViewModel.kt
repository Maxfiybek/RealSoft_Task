package com.example.realsofttask.common.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import org.koin.core.component.KoinComponent

abstract class BaseViewModel<STATE, EVENT>(initialState: STATE) : ViewModel(), KoinComponent {

    protected val mutableState: MutableStateFlow<STATE> = MutableStateFlow(initialState)
    val state: StateFlow<STATE> = mutableState.asStateFlow()

    protected val mutableEvents = Channel<EVENT>(BUFFERED)
    val events = mutableEvents.receiveAsFlow()
}