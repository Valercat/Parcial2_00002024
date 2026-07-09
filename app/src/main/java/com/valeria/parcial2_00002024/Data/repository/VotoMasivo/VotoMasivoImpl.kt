package com.valeria.parcial2_00002024.Data.repository.VotoMasivo

import com.valeria.parcial2_00002024.Data.database.dao.OptionDao
import com.valeria.parcial2_00002024.Data.database.dao.QuestionDao
import com.valeria.parcial2_00002024.Data.model.Question
import com.valeria.parcial2_00002024.Data.model.Vote
import kotlinx.coroutines.flow.Flow

class VotoMasivoImpl(
    private val optionDao : OptionDao,
    private val questionDao : QuestionDao
): VotoMasivoRepository {
    override fun getQuestions(): Flow<List<Question>> {
        TODO("Not yet implemented")
    }

    override suspend fun postVotes(votes: List<Vote>) {
        TODO("Not yet implemented")
    }

}