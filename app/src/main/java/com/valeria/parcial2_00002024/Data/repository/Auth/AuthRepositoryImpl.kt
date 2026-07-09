package com.valeria.parcial2_00002024.Data.repository.Auth

import com.valeria.parcial2_00002024.Data.remote.KtorClient
import com.valeria.parcial2_00002024.Data.remote.dto.LoginDto.LoginRequestDto
import com.valeria.parcial2_00002024.Data.remote.dto.LoginDto.LoginResponseDto
import com.valeria.parcial2_00002024.Data.session.SessionManager
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthRepositoryImpl(
    private val session: SessionManager
) : AuthRepository {

    // Hay sesión si hay token guardado
    override val isLoggedIn: Flow<Boolean> = session.token.map { it != null }
    override val userName: Flow<String?> = session.userName

    override suspend fun login(carnet: String) {
        val response: LoginResponseDto = KtorClient.client.post("/functions/v1/rankeuca/register") {
            contentType(ContentType.Application.Json)
            setBody(LoginRequestDto(carnet))
        }.body()

        // Login exitoso: guardamos la sesión usando el apiKey y el carnet
        if (response.ok) {
            session.save(response.apiKey, carnet)
        }
    }

    override suspend fun logout() {
        session.clear()
    }
}
