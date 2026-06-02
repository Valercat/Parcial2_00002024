package com.valeria.parcial2_00002024.Screen.Resultado

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valeria.parcial2_00002024.Data.api.repositories.RankedApi
import com.valeria.parcial2_00002024.Data.api.repositories.RankedInterface
import com.valeria.parcial2_00002024.Model.RankedModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel(){
    private val rankedRepository: RankedInterface = RankedApi()

    private val _ranked = MutableStateFlow<List<RankedModel>>(emptyList())
    val ranked = _ranked.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    init{
        rankedVotos()
    }

    fun rankedVotos(){
    viewModelScope.launch {
        _error.value = null
        rankedRepository.GetRankedDto()
            .onSuccess { ranked -> _ranked.value = ranked}
            .onFailure {error -> _error.value = error.message}
    }
    }
}