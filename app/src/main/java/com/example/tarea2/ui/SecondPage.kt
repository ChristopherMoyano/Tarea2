package com.example.tarea2.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.tarea2.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(navController: NavController, id: Int){
    val viewModel: SharedViewModel = viewModel()
    val categoria = viewModel.animeList.find{it.id == id}
    var selected by remember { mutableIntStateOf(0) }

    Scaffold (modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title ={
                    Text("AnimeList")
                }
            )
        }

    ) { innerPadding ->
        Column (
            modifier = Modifier.padding(innerPadding).fillMaxWidth(),
            horizontalAlignment =androidx.compose.ui.Alignment.CenterHorizontally,
        ){
            if (categoria != null) {
                ListContent(categoria.contenido, selected) { selected = it }
            } else {
                Text("Categoría no encontrada", modifier = Modifier.padding(16.dp))
            }
        }
        Column (
            modifier = Modifier.padding(innerPadding).fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom
        ){
            FloatingActionButton(
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(R.drawable.siguiente),
                    contentDescription = "next",
                    modifier = Modifier.size(30.dp)
                )
            }

            androidx.compose.foundation.layout.Spacer(modifier = Modifier.padding(10.dp))

            FloatingActionButton(
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(R.drawable.anadir),
                    contentDescription = "Add",
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Composable
fun ListContent(animeList: List<Contenido>, selected: Int, changeSelected: (Int)-> Unit){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(20.dp),
        modifier = Modifier.fillMaxWidth()
    ){
        items(animeList){
            Card(
                colors = CardColors(
                    containerColor = if (selected == it.id) Color(48, 78, 253, 255) else Color(
                        26,
                        40,
                        65,
                        255
                    ),
                    contentColor = Color.White,
                    disabledContentColor = Color.White,
                    disabledContainerColor = Color.Transparent,
                ),
                modifier = Modifier
                    .padding(10.dp)
                    .clickable { changeSelected(it.id) }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 10.dp, top = 10.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    if (selected == it.id) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Check Circle"
                        )
                    } else {
                        // Reserva el mismo espacio con un icono invisible
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = null,
                            modifier = Modifier.alpha(0f)
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(start = 20.dp, end = 20.dp, top = 0.dp, bottom = 30.dp),
                    horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    val painter = runCatching { painterResource(id = it.image)}.getOrNull()
                    if(painter != null){
                        Image(
                            painter = painterResource(it.image),
                            contentDescription = "Account Box",
                            modifier = Modifier.size(50.dp)
                        )
                    }
                    else{
                        Text("Imagen no encontrada", color = Color.Red)
                    }
                    Text(
                        text = it.title,
                        color = Color.White,
                        modifier = Modifier.padding(top = 10.dp)
                    )
                }
            }

        }
    }
}
