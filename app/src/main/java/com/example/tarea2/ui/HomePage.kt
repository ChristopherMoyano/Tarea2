package com.example.tarea2.ui

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
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController){
    var selected by remember { mutableIntStateOf(0)}
    val Categoria = Categoria(id= 0, title = "pelea", icon = R.drawable., contenido = mutableListOf<Contenido>())


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
            verticalArrangement =Arrangement.Bottom
        ){  }
    }

}

@Composable
fun ListCategoria(categorias: List<Categoria>, selected: Int, changeSelected: (Int)-> Unit){
    LazyVerticalGrid(
        columns =GridCells.Fixed(2),
        contentPadding = PaddingValues(20.dp),
        modifier = Modifier.fillMaxWidth()
    ){
        items(categorias){
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

                    Icon(
                        painter = painterResource(it.icon),
                        contentDescription = "Account Box",
                        modifier = Modifier.size(50.dp)
                    )
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

class Categoria(val id: Int, val title: String, val icon: Int, val contenido: MutableList<Contenido>){


}
class Contenido(val id: Int, val title: String, val image: Int, val description: String){

}