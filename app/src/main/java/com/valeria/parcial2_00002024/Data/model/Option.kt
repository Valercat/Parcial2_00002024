package com.valeria.parcial2_00002024.Data.model

import com.valeria.parcial2_00002024.Data.database.entities.OptionEntity

//modelo que ve la app
data class Option(
    val id: Int = 0,
    val name: String,
    val imageUrl: String
)

//mappers

//pasa de entity al modelo de la app
fun OptionEntity.toModel(): Option {
    return Option(
        id = id,
        name = name,
        imageUrl = imageUrl
    )
}

//pasa de modelo de la app a entity
//dice como se guarda
fun Option.toEntity(): OptionEntity {
    return OptionEntity(
        id = id,
        name = name,
        imageUrl = imageUrl
    )
}