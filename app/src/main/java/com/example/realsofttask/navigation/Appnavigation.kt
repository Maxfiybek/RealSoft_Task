package com.example.realsofttask.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.realsofttask.ui.screens.home.HomeScreen
import com.example.realsofttask.ui.screens.login.LoginScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    token: String
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = if (token.isBlank()) LoginScreen else HomeScreen

    ) {
        composable<LoginScreen> {
            LoginScreen()
        }
        composable<HomeScreen> {
            HomeScreen()
        }

    }
}