package com.example.lectureexamples

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lectureexamples.screens.DetailScreen
import com.example.lectureexamples.screens.HomeScreen

@Composable
fun MyNavigation(){
    val myController = rememberNavController()
    NavHost(navController = myController, startDestination = "homeScreen"){
        composable("homeScreen"){
            HomeScreen(navController = myController)
        }

        composable(route = "detailScreen/{movieId}",
        arguments = listOf(navArgument("movieId")
        {
            type = NavType.StringType
        }))
        {
            backStackEntry -> DetailScreen(navController = myController, movieId = backStackEntry.arguments?.getString("movieId").toString())
        }
    }
}