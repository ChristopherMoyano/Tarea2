package com.example.tarea2

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.tarea2.ui.Categoria
import com.example.tarea2.ui.Contenido
import com.example.tarea2.ui.FormularioScreen
import com.example.tarea2.ui.HomeScreen
import com.example.tarea2.ui.SecondScreen
import kotlinx.serialization.Serializable
import androidx.compose.material3.Text
import com.example.tarea2.ui.FormularioContentScreen
import com.example.tarea2.ui.DetalleContenidoScreen

@Serializable
object Home

@Serializable
data class SecondPage(val id: Int)

@Serializable
data class FormularioCat(val size: Int)

@Serializable
data class FormularioCont(val categoriaId: Int, val contenidoSize: Int)

@Serializable
data class DetalleContenidoPage(val idCategoria: Int, val idContenido: Int)



@Composable
fun Navigation(){
    val navController = rememberNavController()
    val categoria = remember{ mutableStateListOf<Categoria>().apply{
        add(
            Categoria(
                id=0,
                title = "Accion",
                icon = R.drawable.accion,
                contenido = mutableListOf(
                    Contenido(0,"Naruto",R.drawable.naruto,"un ninja legendario"),
                    Contenido(1,"Bleach",R.drawable.bleach,"Shinigamis y espadas")
                )
            )
        )
        add(
            Categoria(
                id =1,
                title = "Romance",
                icon = R.drawable.romance,
                contenido = mutableListOf()
            )
        )
        add(
            Categoria(
                id =2,
                title = "Fantasia",
                icon = R.drawable.fantasia,
                contenido = mutableListOf()
            )
        )
    }}

    val agregarCategoria:(Categoria)-> Unit ={ nuevaCategoria -> categoria.add(nuevaCategoria)}
    val agregarContenido:(Int,Contenido)->Unit={categoriaId,nuevoContenido ->
        categoria.find{it.id == categoriaId}?.contenido?.add(nuevoContenido)
    }

    //------------------------------------------------------------------------------------------

    NavHost(navController = navController, startDestination = Home){
        composable<Home>{
            HomeScreen(categoria = categoria,
                onNavigateToFormulario = {navController.navigate(
                                          FormularioCat(size = categoria.size))},
                navController = navController)
        }

        composable<SecondPage>{ backStackEntry ->
            val args = backStackEntry.toRoute<SecondPage>()
            val selectedCategoria = categoria.find{it.id == args.id}
            if(selectedCategoria !=null){
                SecondScreen(navController,selectedCategoria)
            }
            else{
                Text("Categoría no encontrada")
            }
        }

        composable <FormularioCat>{
            FormularioScreen(onAgregar = agregarCategoria,
                onBack = {navController.popBackStack()},
                categoria.size)
        }

        composable<FormularioCont> { backStackEntry ->
            val args = backStackEntry.toRoute<FormularioCont>()
            FormularioContentScreen(
                onAgregar = { nuevoContenido ->
                    agregarContenido(args.categoriaId, nuevoContenido)
                    navController.popBackStack()
                },
                onBack = { navController.popBackStack() },
                contenidoSize = args.contenidoSize
            )
        }

        composable<DetalleContenidoPage> { backStackEntry ->
            val args = backStackEntry.toRoute<DetalleContenidoPage>()
            val categoriaSeleccionada = categoria.find { it.id == args.idCategoria }
            val contenidoSeleccionado = categoriaSeleccionada?.contenido?.find { it.id == args.idContenido }

            if (contenidoSeleccionado != null) {
                DetalleContenidoScreen(contenido = contenidoSeleccionado,navController)
            } else {
                Text("Contenido no encontrado")
            }
        }


    }
}