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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.tarea2.R
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import com.example.tarea2.FormularioCat
import com.example.tarea2.SecondPage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController){
    val viewModel: SharedViewModel = viewModel()
    var selected by remember { mutableIntStateOf(0)}
    val animeList = viewModel.animeList
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
            ListCard(animeList,selected,{selected = it})
        }
        Column (
            modifier = Modifier.padding(innerPadding).fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom
        ){
            FloatingActionButton(
                onClick = {
                    navController.navigate(SecondPage(selected))
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.siguiente),
                    contentDescription = "next",
                    modifier = Modifier.size(30.dp)
                )
            }

            androidx.compose.foundation.layout.Spacer(modifier = Modifier.padding(10.dp))

            FloatingActionButton(
                onClick = {
                    navController.navigate(FormularioCat)
                }
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
fun ListCard(animeList: List<Categoria>, selected: Int, changeSelected: (Int)-> Unit){
    LazyVerticalGrid(
        columns =GridCells.Fixed(2),
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

class SharedViewModel : ViewModel() {

    var animeList by mutableStateOf(
        mutableListOf(
            Categoria(
                id = 0,
                title = "Accion",
                icon = R.drawable.accion,
                contenido = mutableListOf(
                    Contenido(0, "Naruto", R.drawable.naruto, "Un ninja legendario"),
                    Contenido(1, "Bleach", R.drawable.bleach, "Shinigamis y espadas")
                )
            ),
            Categoria(
                id = 1,
                title = "Romance",
                icon = R.drawable.romance,
                contenido = mutableListOf()
            ),
            Categoria(
                id = 2,
                title = "Fantasia",
                icon = R.drawable.fantasia,
                contenido = mutableListOf()
            )
        )
    )

    var selectedCategoria by mutableStateOf<Categoria?>(null)

    fun addCategoria(categoria: Categoria) {
        animeList.add(categoria)
    }

    fun addContenidoToCategoria(categoriaId: Int, contenido: Contenido) {
        animeList.find { it.id == categoriaId }?.contenido?.add(contenido)
    }
}


