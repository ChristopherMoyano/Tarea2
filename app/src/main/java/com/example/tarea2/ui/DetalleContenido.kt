package com.example.tarea2.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tarea2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleContenidoScreen(contenido: Contenido,navController: NavController) {

    Scaffold (modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title ={
                    Row(
                        verticalAlignment = Alignment.CenterVertically // alinea verticalmente al centro
                    ) {

                        FloatingActionButton(
                            onClick = { navController.popBackStack() },
                            modifier = Modifier.size(40.dp)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.atras),
                                contentDescription = "Back",
                                modifier = Modifier.size(30.dp)
                            )
                        }


                        androidx.compose.foundation.layout.Spacer(modifier = Modifier.width(12.dp))

                        Text(text = contenido.title)
                    }
                }
            )
        }

    ) { innerPadding ->
        Column (
            modifier = Modifier.padding(innerPadding).fillMaxWidth(),
            horizontalAlignment =androidx.compose.ui.Alignment.CenterHorizontally,
        ){
            val painter = runCatching { painterResource(id = contenido.image) }.getOrNull()
            if (painter != null) {
                Image(
                    painter = painter,
                    contentDescription = contenido.title,
                    modifier = Modifier.size(200.dp)
                )
            }
            androidx.compose.foundation.layout.Spacer(modifier = Modifier.padding(10.dp))
            Text(text = contenido.description, style = MaterialTheme.typography.bodyLarge)
        }

    }
}
