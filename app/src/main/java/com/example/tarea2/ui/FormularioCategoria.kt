package com.example.tarea2.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tarea2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormularioScreen(
    onAgregar: (Categoria) -> Unit,
    onBack: () -> Unit,
    size : Int
) {
    var nombre by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically // alinea verticalmente al centro
                    ) {

                        FloatingActionButton(
                            onClick = onBack,
                            modifier = Modifier.size(40.dp)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.atras),
                                contentDescription = "Back",
                                modifier = Modifier.size(30.dp)
                            )
                        }


                        androidx.compose.foundation.layout.Spacer(modifier = Modifier.width(12.dp))

                        Text(text = "AnimeList")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Nueva categoría", style = MaterialTheme.typography.headlineSmall)

            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre de categoría") }
            )

            Button(
                onClick = {
                    val nuevaCategoria = Categoria(
                        id = size,
                        title = nombre,
                        icon = R.drawable.otros,
                        contenido = mutableListOf()
                    )
                    onAgregar(nuevaCategoria)
                    onBack()
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Guardar")
            }
        }
    }
}
