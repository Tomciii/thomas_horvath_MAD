package com.example.lectureexamples.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.lectureexamples.composables.topAppBar.FAVORITES
import com.example.lectureexamples.composables.topAppBar.HomeTopAppBar
import com.example.lectureexamples.composables.topAppBar.SimpleTopAppBar
import com.example.lectureexamples.screens.Screen

@Composable
fun MyTopAppBar(screen:String, topAppBarText:String = "", navController: NavController?){

    when(screen){
        Screen.Home.route -> HomeTopAppBar(navController = navController)
        Screen.Favorites.route -> SimpleTopAppBar(topAppBarText = FAVORITES, navController = navController)
        Screen.Detail.route -> SimpleTopAppBar(topAppBarText = topAppBarText, navController = navController)
    }
}
