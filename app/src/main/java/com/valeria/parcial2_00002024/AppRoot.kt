package com.valeria.parcial2_00002024

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.valeria.parcial2_00002024.Screen.Auth.AuthViewModel
import com.valeria.parcial2_00002024.Screen.Login.LoginScreen
import com.valeria.parcial2_00002024.Screen.SplashScreen

@Composable
fun AppRoot(
    authViewModel: AuthViewModel = viewModel(factory = AuthViewModel.Factory)
) {
    val isLoggedIn by authViewModel.isLoggedIn.collectAsState()

    when (isLoggedIn) {
        null -> SplashScreen()          // DataStore todavía cargando
        false -> LoginScreen()          // sin sesión
        true -> RankeUCA_App(         // con sesión: la app completa
            userName = authViewModel.userName.collectAsState().value,
            onLogout = { authViewModel.logout() }
        )
    }
}