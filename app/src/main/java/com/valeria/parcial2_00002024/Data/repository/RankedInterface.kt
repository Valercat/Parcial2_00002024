package com.valeria.parcial2_00002024.Data.repository

import com.valeria.parcial2_00002024.Data.remote.dto.PostResponseDTO
import com.valeria.parcial2_00002024.Model.RankedModel

interface RankedInterface {
    suspend fun getRankedList(): Result<List<RankedModel>>
    suspend fun postRankedVoto(optionId: Int): Result<PostResponseDTO>
}