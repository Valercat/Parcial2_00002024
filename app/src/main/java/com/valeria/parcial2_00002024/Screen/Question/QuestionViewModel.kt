package com.valeria.parcial2_00002024.Screen.Question

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.valeria.parcial2_00002024.Data.model.Option
import com.valeria.parcial2_00002024.Data.model.Question
import com.valeria.parcial2_00002024.Data.repository.OptionRepository
import com.valeria.parcial2_00002024.Data.repository.QuestionRepository
import com.valeria.parcial2_00002024.RankeUCA_Application
import com.valeria.parcial2_00002024.Screen.Options.OptionsViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class QuestionViewModel(
    private val questionRepository: QuestionRepository
): ViewModel() {

    val question: StateFlow<List<Question>> =
        questionRepository.getQuestions()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    fun addQuestion(title: String){
        viewModelScope.launch {
            questionRepository.addQuestion(
                title = title
            )
        }
    }

    fun deleteQuestion(question: Question){
        viewModelScope.launch {
            questionRepository.deleteQuestion(question)
        }
    }
    fun updateQuestion(question: Question){
        viewModelScope.launch {
            questionRepository.updateQuestion(question)
        }
    }
    companion object{
        val Factory = viewModelFactory{
            initializer{
                val app = this[APPLICATION_KEY] as RankeUCA_Application
                //recibe un repository en el constructor y lo devuelve ya construidp
                QuestionViewModel(app.appProvider.provideQuestionRepository())
            }
        }
    }
}