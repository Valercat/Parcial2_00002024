package com.valeria.parcial2_00002024.Screen.Auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.valeria.parcial2_00002024.Data.repository.Auth.AuthRepository
import com.valeria.parcial2_00002024.RankeUCA_Application
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AuthViewModel(
    private val repository: AuthRepository
) : ViewModel() {

    // null = todavía no sabemos (DataStore cargando)
    val isLoggedIn: StateFlow<Boolean?> = repository.isLoggedIn
        //inicia en null porq datastore tarda en cargar
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), null)

    val userName: StateFlow<String?> = repository.userName
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), null)

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    fun login(email: String) {
        viewModelScope.launch {
            _error.value = null
            _isLoading.value = true
            try {
                repository.login(email)
            } catch (e: Exception) {
                _error.value = "Correo o contraseña incorrectos"
            }
            _isLoading.value = false
        }
    }

    fun logout() {
        viewModelScope.launch { repository.logout() }
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as RankeUCA_Application
                AuthViewModel(app.appProvider.provideAuthRepository())
            }
        }
    }
}