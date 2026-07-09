package com.valeria.parcial2_00002024.Data.remote.dto.LoginDto

import kotlinx.serialization.Serializable
//y en lugar de devolver token y user devuelve si si se pudo y la apiKey
@Serializable
data class LoginResponseDto(
    val ok: Boolean,
    val apiKey: String
)
