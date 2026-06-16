package com.valeria.parcial2_00002024.Data.model

import androidx.room.PrimaryKey
import com.valeria.parcial2_00002024.Data.database.entities.OptionEntity

//modelo que ve la app
data class Option(
    val id: Int = 0,
    val name: String,
    val imageUrl: String,
    val questionId: Int = 0,
)

fun Option.toEntity(): OptionEntity {
    return OptionEntity(
        id = id,
        name = name,
        imageUrl = imageUrl,
        questionId = questionId,
    )
}

fun OptionEntity.toModel(): Option {
    return Option(
        id = id,
        name = name,
        imageUrl = imageUrl,
        questionId = questionId,
    )
}