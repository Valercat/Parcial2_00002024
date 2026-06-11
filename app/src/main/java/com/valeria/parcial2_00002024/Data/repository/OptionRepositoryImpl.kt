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
    override fun getOptions(): Flow<List<Option>> {
        return optionDao.getAllOptions().map{ entities ->
            entities.map{ it.toModel()}
        }
    }
    override suspend fun addOption(option: Option) {
        optionDao.insertOption(option.toEntity())
    }
    override suspend fun deleteOption(option: Option) {
        optionDao.deleteOption(option.toEntity())
    }
}
