package com.example.tarea2.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.tarea2.R

@Composable
fun FormularioScreen(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    val viewModel: SharedViewModel = viewModel()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Nueva categoría", style = MaterialTheme.typography.headlineSmall)
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre de categoría") }
        )

        Button(
            onClick = {
                val nuevaCategoria = Categoria(
                    id = viewModel.animeList.size,
                    title = nombre,
                    icon = R.drawable.otros, // ícono por defecto o personalizado
                    contenido = mutableListOf()
                )
                viewModel.addCategoria(nuevaCategoria)
                navController.popBackStack() // Volver al Home
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Guardar")
        }
    }
}