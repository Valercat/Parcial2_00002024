package com.valeria.parcial2_00002024.Data.api.repositories

import android.util.Log
import com.valeria.parcial2_00002024.Data.api.KtorClient
import com.valeria.parcial2_00002024.Data.api.dto.GetRankedDto
import com.valeria.parcial2_00002024.Data.api.dto.PostRankedDTO
import com.valeria.parcial2_00002024.Data.api.dto.toModel
import com.valeria.parcial2_00002024.Model.RankedModel
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlin.collections.map

class RankedApi: RankedInterface{
    override suspend fun GetRankedDto(): Result<List<RankedModel>> {
        try {
            val response: List<GetRankedDto> = KtorClient.client.get("/options").body()

            return Result.success(response.map { apiRanked -> apiRanked.toModel() })
        }
        catch (e: Exception){
            Log.e("RankedUCA_Api", "Error al obtener lista de JSONs: ${e.message}")
            return Result.failure(e)
        }
    }

    override suspend fun PostRankedDTO(optionId: Int): Result<PostRankedDTO> {
        try {
            val request = PostRankedDTO(
                optionId = optionId
            )

            val response: PostRankedDTO = KtorClient.client
                .post("https://jsonplaceholder.typicode.com/posts") {
                    contentType(ContentType.Application.Json)
                    setBody(request)
                }
                .body()

            return Result.success(response)
        } catch (e: Exception) {
            Log.e("RankedUCA_Api", "Error al obtener votos: ${e.message}")
            return Result.failure(e)
        }
    }

}