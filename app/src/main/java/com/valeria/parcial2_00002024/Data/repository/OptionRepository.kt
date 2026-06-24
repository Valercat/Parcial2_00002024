package com.valeria.parcial2_00002024.Data.repository

import com.valeria.parcial2_00002024.Data.model.Option
import kotlinx.coroutines.flow.Flow

interface OptionRepository {
    fun getOptionsForQuestions(questionId: Int): Flow<List<Option>>
    suspend fun addOption(value: String, imageUrl: String, questionId: Int)
    suspend fun deleteOption(option: Option)
    suspend fun updateOption(option: Option)
}