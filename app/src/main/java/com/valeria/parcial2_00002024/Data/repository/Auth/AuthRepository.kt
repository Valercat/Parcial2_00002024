package com.valeria.parcial2_00002024.Data.repository.Auth

import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    val isLoggedIn: Flow<Boolean>
    val userName: Flow<String?>
    //el login aqui tmb se ve solo carnet
    suspend fun login(carnet: String)
    suspend fun logout()
}