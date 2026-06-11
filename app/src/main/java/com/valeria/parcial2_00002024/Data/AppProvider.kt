package com.valeria.parcial2_00002024.Data

import android.content.Context
import com.valeria.parcial2_00002024.Data.database.AppDatabase
import com.valeria.parcial2_00002024.Data.repository.OptionRepository
import com.valeria.parcial2_00002024.Data.repository.OptionRepositoryImpl

class AppProvider (context: Context){

    private val appDatabase = AppDatabase.getDatabase(context)
    private val optionDao = appDatabase.optionDao()

    private val optionRepository: OptionRepository =
        OptionRepositoryImpl(optionDao)

    fun provideOptionRepository(): OptionRepository{
        return optionRepository
    }
}