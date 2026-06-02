package com.valeria.parcial2_00002024.Data.api.dto

import com.valeria.parcial2_00002024.Model.RankedModel
import kotlinx.serialization.Serializable
import kotlin.Int

@Serializable

data class GetRankedDto(
    val id: Int,
    val imageUrl: String,
    val name: String,
    val votes: Int
)
fun GetRankedDto.toModel(): RankedModel{
    return RankedModel(
        id = id,
        imageUrl = imageUrl,
        name = name,
        votes = votes
    )
}