package com.valeria.parcial2_00002024.Data.api.repositories

import com.valeria.parcial2_00002024.Data.api.dto.GetRankedDto
import com.valeria.parcial2_00002024.Data.api.dto.PostRankedDTO
import com.valeria.parcial2_00002024.Model.RankedModel

interface RankedInterface {
    suspend fun GetRankedDto(): Result<List<RankedModel>>
    suspend fun PostRankedDTO(optionId: Int): Result<PostRankedDTO>
}