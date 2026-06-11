package com.valeria.parcial2_00002024.Data.repository

import com.valeria.parcial2_00002024.Data.model.Option
import kotlinx.coroutines.flow.Flow

interface OptionRepository {
    fun getOptions(): Flow<List<Option>>
    suspend fun addOption(option: Option)
    suspend fun deleteOption(option: Option)
}