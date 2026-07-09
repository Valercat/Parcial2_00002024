package com.valeria.parcial2_00002024.Screen.Home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    userName: String?,
    onLogout: () -> Unit,
    onQuestionClick: () -> Unit,
    onVoteClick: () -> Unit,
    onOptionClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Home") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Bienvenido, $userName",
                style = MaterialTheme.typography.headlineSmall
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                onClick = onQuestionClick
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Gestor de preguntas",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

//            Card(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(120.dp),
//                onClick = { onOptionClick
//                          },
//                enabled = true
//            ) {
//                Box(
//                    modifier = Modifier.fillMaxSize(),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Text(
//                        text = "Opciones",
//                        style = MaterialTheme.typography.titleLarge,
//                        textAlign = TextAlign.Center
//                    )
//                }
//            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                onClick = onVoteClick,
                enabled = true
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Voto masivo",
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center
                    )
                }
            }

            TextButton(
                onClick = onLogout,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Cerrar sesión")
            }
        }
    }
}
