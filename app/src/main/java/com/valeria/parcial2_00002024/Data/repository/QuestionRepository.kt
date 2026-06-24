package com.valeria.parcial2_00002024.Data.repository

import com.valeria.parcial2_00002024.Data.model.Question
import kotlinx.coroutines.flow.Flow

interface QuestionRepository {
    fun getQuestions(): Flow<List<Question>>
    suspend fun addQuestion(title: String)
    suspend fun deleteQuestion(question: Question)

    suspend fun updateQuestion(question: Question)

}