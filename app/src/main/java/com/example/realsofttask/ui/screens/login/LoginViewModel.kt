package com.example.realsofttask.ui.screens.login

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.realsofttask.common.viewModel.BaseViewModel
import com.example.realsofttask.data.network.AppRepository
import com.example.realsofttask.domain.mapper.mapToUiModel
import com.example.realsofttask.utils.DataBase
import com.example.realsofttask.utils.extensions.resultOf
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val preference: SharedPreferences,
    private val repository: AppRepository
) : BaseViewModel<LoginState, LoginEvents>(LoginState()) {

    fun login(email: String, password: String) {
        Log.d("Requested Data", "::: password -> $password, email -> $email")
        viewModelScope.launch {
            resultOf {
                mutableEvents.send(LoginEvents.Loading)
                repository.login(email = email, password = password)
            }.onSuccess {
                saveToken(it.token)
                mutableEvents.send(LoginEvents.Success(it.userDto.mapToUiModel()))
                Log.d(
                    "Success",
                    "::: password -> ${state.value.password}, email -> ${state.value.gmail}"
                )
            }.onFailure {
                Log.d("Error", "::: ${it.message}")
                mutableEvents.send(LoginEvents.Error(it.message.toString()))
            }
        }
    }

    private fun saveToken(token: String) {
        viewModelScope.launch {
            preference.edit().putString(DataBase.TOKEN, token).apply()
        }
    }

    fun onPasswordChange(password: String) {
        mutableState.update { it.copy(password = password) }
    }

    fun onGmailChange(gmail: String) {
        mutableState.update { it.copy(gmail = gmail) }
    }
}