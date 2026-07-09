package com.valeria.parcial2_00002024.Data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.valeria.parcial2_00002024.Data.database.AppDatabase
import com.valeria.parcial2_00002024.Data.repository.Auth.AuthRepository
import com.valeria.parcial2_00002024.Data.repository.Auth.AuthRepositoryImpl
import com.valeria.parcial2_00002024.Data.repository.OptionRepository
import com.valeria.parcial2_00002024.Data.repository.OptionRepositoryImpl
import com.valeria.parcial2_00002024.Data.repository.QuestionRepository
import com.valeria.parcial2_00002024.Data.repository.QuestionRepositoryImpl
import com.valeria.parcial2_00002024.Data.session.SessionManager

//val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "session")

class AppProvider (context: Context){

    private val appDatabase = AppDatabase.getDatabase(context)
    private val optionDao = appDatabase.optionDao()
    private val questionDao = appDatabase.questionDao()

    private val optionRepository: OptionRepository =
        OptionRepositoryImpl(optionDao)
    private val questionRepository: QuestionRepository =
        QuestionRepositoryImpl(questionDao)

    private val authRepository: AuthRepository =
        AuthRepositoryImpl(SessionManager(context))


    fun provideOptionRepository(): OptionRepository{
        return optionRepository
    }
    fun provideQuestionRepository(): QuestionRepository {
        return questionRepository
    }
    fun provideAuthRepository(): AuthRepository {
        return authRepository
    }
}