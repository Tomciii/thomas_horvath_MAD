package com.example.lectureexamples.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.lectureexamples.screens.composable.MyList
import com.example.lectureexamples.screens.composable.MyTopAppBar

@Composable
fun HomeScreen(navController: NavController)  {

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                Column {
                  MyTopAppBar(Screen.Home.route, "", navController)
                  MyList(navController)
                }
            }
}
