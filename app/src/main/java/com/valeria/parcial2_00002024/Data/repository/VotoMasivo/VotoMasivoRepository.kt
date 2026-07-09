package com.valeria.parcial2_00002024.Data.repository.VotoMasivo

import com.valeria.parcial2_00002024.Data.model.Question
import com.valeria.parcial2_00002024.Data.model.Vote
import kotlinx.coroutines.flow.Flow

interface VotoMasivoRepository {
    fun getQuestions(): Flow<List<Question>>
    suspend fun postVotes(votes: List<Vote>)
}