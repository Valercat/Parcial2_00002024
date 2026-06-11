package com.valeria.parcial2_00002024.Data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

//entity es la tabla de la bd
//cada propiedad es una columna

@Entity(tableName = "options")
//clase con nombre options
data class OptionEntity(
    //genera un id unico
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val imageUrl: String
)