package com.valeria.parcial2_00002024.Screen.Options

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.valeria.parcial2_00002024.Data.model.Option


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OptionsScreen(
    questionId: Int,
    viewModel: OptionsViewModel = viewModel(
        key = "OptiosViewModel_$questionId",
        factory = OptionsViewModel.provideFactory(questionId)
    ),
    navigateBack: () -> Unit
) {
    val options by viewModel.options.collectAsStateWithLifecycle()
    var showSheet by rememberSaveable { mutableStateOf(false) }

    //puede o no recibir el objeto de option, esta seteado en null por defecto
    //pero luego en el boton se le asigna para luego enviarlo al view model y al bottomsheet
    var selectedOption by remember { mutableStateOf<Option?>(null) }


    Scaffold(
        containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
        topBar = {
            TopAppBar(
                title = { Text("Administrar opciones") },
                actions = {
                    Row{
                    TextButton(onClick = {
                        selectedOption = null
                        showSheet = true
                    }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Nueva opción")
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Nuevo")
                    }
                    TextButton(onClick = navigateBack) {
                        Text("Volver")
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Volcer",
                            tint = MaterialTheme.colorScheme.error
                        )
                    }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {

            if (options.isEmpty()) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.height(36.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Todavia no hay opciones",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Toca Nuevo para crear la primera.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(vertical = 4.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(items = options, key = { it.id }) { option ->
                        ElevatedCard {
                            ListItem(
                                headlineContent = {
                                    Text(
                                        text = option.value,
                                        style = MaterialTheme.typography.titleMedium
                                    )
                                },
                                supportingContent = {
                                    option.imageUrl?.let {
                                        Text(
                                            text = it,
                                            style = MaterialTheme.typography.bodySmall,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                },
                                trailingContent = {
                                    IconButton(onClick = { viewModel.deleteOption(option) }) {
                                        Icon(
                                            imageVector = Icons.Default.Delete,
                                            contentDescription = "Borrar ${option.value}",
                                            tint = MaterialTheme.colorScheme.error
                                        )
                                    }
                                    IconButton(onClick  = {
                                        selectedOption = option
                                        showSheet = true}){
                                        Icon(
                                            imageVector = Icons.Default.Edit,
                                            contentDescription = "Editar ${option.value}"
                                        )

                                    }
                                }
                            )
                        }
                    }

                }
            }
        }
    }

    if (showSheet) {
        OptionBottomSheet(
            Option = selectedOption,
            onDismiss = { showSheet = false
                        selectedOption = null},
            onSave = { name, url ->
                if (selectedOption == null) {
                    viewModel.addOption(name, url)
                } else {
                    //copia el id del option escogido
                    viewModel.updateOption(selectedOption!!.copy(value = name, imageUrl = url) )
                }
            }
        )
    }
}