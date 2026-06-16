package com.valeria.parcial2_00002024

import android.app.Application
import com.valeria.parcial2_00002024.Navigation.Routes

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.valeria.parcial2_00002024.Data.AppProvider
import com.valeria.parcial2_00002024.Screen.Options.OptionsScreen
import com.valeria.parcial2_00002024.Screen.Question.QuestionsScreen
import com.valeria.parcial2_00002024.Screen.Resultado.HomeScreen
import java.util.Map.entry

@Composable
fun RankeUCA_App() {
    val backStack = rememberNavBackStack(Routes.Question)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Question> {
                QuestionsScreen(
                    onQuestionClick = { questionId ->
                        backStack.add(Routes.Options(questionId))
                    }
                )
            }
            entry<Routes.Options> { key ->
                OptionsScreen(
                    questionId = key.questionId,
                    navigateBack = { backStack.removeLastOrNull() }
                )
            }
        }
    )
}

class RankeUCA_Application : Application(){
    val appProvider by lazy { AppProvider(this) }
}