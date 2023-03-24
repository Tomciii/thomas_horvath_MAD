package com.example.lectureexamples.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.lectureexamples.composables.topAppBar.HomeTopAppBar
import com.example.lectureexamples.composables.topAppBar.SimpleTopAppBar
import com.example.lectureexamples.screens.Screen

@Composable
fun MyTopAppBar(screen:String, movieTitle:String = "", navController: NavController?){

    when(screen){
        Screen.Home.route -> HomeTopAppBar(navController = navController)
        Screen.Favorites.route -> SimpleTopAppBar(topAppBarText = "Favorites", navController = navController)
        Screen.Detail.route -> SimpleTopAppBar(topAppBarText = movieTitle, navController = navController)
    }
}
