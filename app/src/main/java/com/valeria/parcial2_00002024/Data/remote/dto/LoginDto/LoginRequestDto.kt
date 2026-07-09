package com.valeria.parcial2_00002024.Data.remote.dto.LoginDto

import com.valeria.parcial2_00002024.Data.api.Auth.UserDto
import kotlinx.serialization.Serializable

//a diferencia de movieapp esta solo necesita el carnet para entrar
@Serializable
data class LoginRequestDto(
    val carnet: String,
)