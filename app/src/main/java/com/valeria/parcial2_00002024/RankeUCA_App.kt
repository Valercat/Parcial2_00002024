package com.valeria.parcial2_00002024

import android.app.Application
import com.valeria.parcial2_00002024.Navigation.Routes

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.valeria.parcial2_00002024.Data.AppProvider
import com.valeria.parcial2_00002024.Screen.Options.OptionsScreen
import com.valeria.parcial2_00002024.Screen.Resultado.HomeScreen

@Composable
fun RankeUCA_App() {
    val backStack = rememberNavBackStack(Routes.Home)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Home> {
//                HomeScreen()
                OptionsScreen()
            }
        },
    )


}

class RankeUCA_Application : Application(){
    val appProvider by lazy { AppProvider(this) }
}