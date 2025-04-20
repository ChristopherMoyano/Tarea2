package com.example.tarea2

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.tarea2.ui.FormularioScreen
import com.example.tarea2.ui.HomeScreen
import com.example.tarea2.ui.SecondScreen
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class SecondPage(val id: Int)

@Serializable
object FormularioCat

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home){
        composable<Home>{
            HomeScreen(navController = navController)
        }
        composable<SecondPage>{ backStackEntry ->
            val args = backStackEntry.toRoute<SecondPage>()
            SecondScreen(navController,args.id)
        }
        composable <FormularioCat>{
            FormularioScreen(navController)
        }
}
}