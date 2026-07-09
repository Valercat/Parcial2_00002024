package com.valeria.parcial2_00002024.Data.api.Auth

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val id: Int,
    val name: String,
    val email: String
)