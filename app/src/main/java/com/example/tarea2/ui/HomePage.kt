package com.example.tarea2.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController){
    var selected by remember { mutableIntStateOf(0)}

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
            horizontalAlignment =androidx.compose.ui.Alignment.CenterHorizontally
        ){  }
    }

}