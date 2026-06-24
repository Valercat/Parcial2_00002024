package com.valeria.parcial2_00002024.Data.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.valeria.parcial2_00002024.Data.model.Option

//entity es la tabla de la bd
//cada propiedad es una columna

@Entity(
    tableName = "options",
    foreignKeys = [
        ForeignKey(
            entity = QuestionEntity::class,
            parentColumns = ["id"],
            childColumns = ["questionId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("questionId")]
)
data class OptionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val value: String,
    val imageUrl: String? = null,
    val questionId: Int,
)

fun OptionEntity.toModel(): Option {
    return Option(
        id = id,
        value = value,
        imageUrl = imageUrl,
        questionId = questionId,
    )
}