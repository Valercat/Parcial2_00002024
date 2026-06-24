package com.valeria.parcial2_00002024.Data.repository

import com.valeria.parcial2_00002024.Data.database.dao.OptionDao
import kotlinx.coroutines.flow.Flow
import com.valeria.parcial2_00002024.Data.model.Option
import com.valeria.parcial2_00002024.Data.model.toEntity
import com.valeria.parcial2_00002024.Data.model.toModel
import kotlinx.coroutines.flow.map

class OptionRepositoryImpl(
    private val optionDao : OptionDao
) : OptionRepository {

    //devuelve el floww del dao
    override fun getOptionsForQuestions(questionId: Int): Flow<List<Option>> {
        return optionDao.getOptionsForQuestion(questionId).map { entities ->
            entities.map{ it.toModel()}
        }
    }
    override suspend fun addOption(value: String, imageUrl: String, questionId: Int) {
        val option = Option(value = value, imageUrl = imageUrl, questionId = questionId)
        optionDao.insertOption(option.toEntity())
    }
    override suspend fun deleteOption(option: Option) {
        optionDao.deleteOption(option.toEntity())
    }

    override suspend fun updateOption(option: Option) {
        optionDao.updateOption(option.toEntity())
    }
}
