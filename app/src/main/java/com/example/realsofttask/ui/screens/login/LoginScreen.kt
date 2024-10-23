package com.example.realsofttask.ui.screens.login

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.realsofttask.common.composables.FillAvailableSpace
import com.example.realsofttask.common.composables.Spacer10dp
import com.example.realsofttask.ui.screens.home.HomeScreen
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
data object LoginScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val viewModel: LoginViewModel = koinViewModel()
    val state = viewModel.state.collectAsState().value
    var loading by remember { mutableStateOf(false) }

    viewModel.events.collectAsState(initial = null).value?.let {
        when (it) {
            is LoginEvents.Error -> {
                loading = false
            }

            LoginEvents.Loading -> {
                loading = true
            }

            is LoginEvents.Success -> {
                loading = false
//                navController.navigate(HomeScreen)
            }
        }
    }

    Scaffold(
        content = { innerPadding ->
            Column(
                modifier = modifier
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Spacer10dp()
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = state.gmail,
                    onValueChange = viewModel::onGmailChange,
                    colors = TextFieldDefaults.colors(
                        disabledIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(10.dp)
                )
                Spacer10dp()
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = state.password,
                    onValueChange = viewModel::onPasswordChange,
                    colors = TextFieldDefaults.colors(
                        disabledIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(10.dp)
                )
                FillAvailableSpace()
                AnimatedVisibility(!loading) {
                    Button(
                        modifier = Modifier
                            .padding(horizontal = 50.dp)
                            .fillMaxWidth(),
                        content = { Text(text = "Login") },
                        shape = RoundedCornerShape(8.dp),
                        onClick = {
                            viewModel.login(email = state.gmail, password = state.password)
                        }
                    )
                }
                if (loading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .padding(horizontal = 50.dp)
                            .fillMaxWidth(),
                        color = Color.Blue
                    )
                }
                Spacer10dp()
            }
        }
    )
}