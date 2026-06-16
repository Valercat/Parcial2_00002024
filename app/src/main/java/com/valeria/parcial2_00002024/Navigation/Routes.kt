package com.valeria.parcial2_00002024.Navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey {
    @Serializable
    data object Home : Routes()

    @Serializable
    data object Question : Routes()
    @Serializable
    data class Options(val questionId: Int) : Routes()

}
