package com.valeria.parcial2_00002024.Data.database.dao

import androidx.room.Query
import com.valeria.parcial2_00002024.Data.database.entities.QuestionEntity

interface VotoMasivoDao {
    @Query("SELECT * FROM questions")
    suspend fun getQuestions(): List<QuestionEntity>
}