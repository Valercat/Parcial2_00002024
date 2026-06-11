package com.valeria.parcial2_00002024.Data.repository

import android.util.Log
import com.valeria.parcial2_00002024.Data.remote.KtorClient
import com.valeria.parcial2_00002024.Data.remote.dto.GetRankedDto
import com.valeria.parcial2_00002024.Data.remote.dto.PostRankedDTO
import com.valeria.parcial2_00002024.Data.remote.dto.PostResponseDTO
import com.valeria.parcial2_00002024.Data.remote.dto.toModel
import com.valeria.parcial2_00002024.Model.RankedModel
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class RankedApi: RankedInterface{
    override suspend fun getRankedList(): Result<List<RankedModel>> {
        try {
            val response: List<GetRankedDto> = KtorClient.client.get("/functions/v1/rankeuca/options").body()

            return Result.success(response.map { apiRanked -> apiRanked.toModel() })
        }
        catch (e: Exception){
            Log.e("RankedUCA_Api", "Error al obtener lista de JSONs: ${e.message}")
            return Result.failure(e)
        }
    }

    override suspend fun postRankedVoto(optionId: Int): Result<PostResponseDTO> {
        try {
            val request = PostRankedDTO(
                optionId = optionId
            )

            val response: PostResponseDTO = KtorClient.client
                .post("/functions/v1/rankeuca/vote") {
                    contentType(ContentType.Application.Json)
                    setBody(request)
                }
                .body()

            return Result.success(response)
        } catch (e: Exception) {
            Log.e("RankedUCA_Api", "Error al registrar voto: ${e.message}")
            return Result.failure(e)
        }
    }
}