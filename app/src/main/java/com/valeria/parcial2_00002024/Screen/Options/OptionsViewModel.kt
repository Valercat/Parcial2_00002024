package com.valeria.parcial2_00002024.Screen.Options

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.valeria.parcial2_00002024.Data.model.Option
import com.valeria.parcial2_00002024.Data.repository.OptionRepository
import com.valeria.parcial2_00002024.RankeUCA_Application
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class OptionsViewModel(
    private val optionRepository: OptionRepository
): ViewModel() {

    val options: StateFlow<List<Option>> =
        optionRepository.getOptions()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    fun addOption(name: String, imageUrl: String){
        viewModelScope.launch {
            optionRepository.addOption(Option(
                name = name,
                imageUrl = imageUrl
            )
            )
        }
    }

    fun deleteOption(option: Option){
        viewModelScope.launch {
            optionRepository.addOption(option)
        }
    }

    companion object{
        val Factory = viewModelFactory{
            initializer{
                val app = this[APPLICATION_KEY] as RankeUCA_Application
                //recibe un repository en el constructor y lo devuelve ya construidp
                OptionsViewModel(app.appProvider.provideOptionRepository())
            }
        }
    }
}