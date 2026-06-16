package com.valeria.parcial2_00002024.Data

import android.content.Context
import com.valeria.parcial2_00002024.Data.database.AppDatabase
import com.valeria.parcial2_00002024.Data.repository.OptionRepository
import com.valeria.parcial2_00002024.Data.repository.OptionRepositoryImpl
import com.valeria.parcial2_00002024.Data.repository.QuestionRepository
import com.valeria.parcial2_00002024.Data.repository.QuestionRepositoryImpl

class AppProvider (context: Context){

    private val appDatabase = AppDatabase.getDatabase(context)
    private val optionDao = appDatabase.optionDao()
    private val questionDao = appDatabase.questionDao()

    private val optionRepository: OptionRepository =
        OptionRepositoryImpl(optionDao)
    private val questionRepository: QuestionRepository =
        QuestionRepositoryImpl(questionDao)

    fun provideOptionRepository(): OptionRepository{
        return optionRepository
    }
    fun provideQuestionRepository(): QuestionRepository {
        return questionRepository
    }
}