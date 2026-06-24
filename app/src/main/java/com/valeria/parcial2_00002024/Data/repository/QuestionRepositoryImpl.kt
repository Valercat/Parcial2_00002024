package com.valeria.parcial2_00002024.Data.repository

import com.valeria.parcial2_00002024.Data.database.dao.QuestionDao
import com.valeria.parcial2_00002024.Data.database.entities.QuestionEntity
import com.valeria.parcial2_00002024.Data.database.entities.toModel
import com.valeria.parcial2_00002024.Data.model.Question
import com.valeria.parcial2_00002024.Data.model.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class QuestionRepositoryImpl(
    private val questionDao: QuestionDao
) : QuestionRepository {

    override fun getQuestions(): Flow<List<Question>> {
        return questionDao.getQuestionsWithOptions().map { list ->
            list.map { it.toModel() }
        }
    }

    override suspend fun addQuestion(title: String) {
        questionDao.insertQuestion(QuestionEntity(title = title))
    }

    override suspend fun deleteQuestion(question: Question) {
        questionDao.deleteQuestion(question.toEntity())
    }

    override suspend fun updateQuestion(question: Question) {
        questionDao.updateQuestion(question.toEntity())
    }
    }
