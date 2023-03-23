package com.example.lectureexamples

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lectureexamples.screens.DetailScreen
import com.example.lectureexamples.screens.HomeScreen
import com.example.lectureexamples.screens.Screen

@Composable
fun MyNavigation(){
    val movieId = "movieId"
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route){
        composable(Screen.Home.route){
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Detail.route + "/{" + movieId + "}",
            arguments = listOf(navArgument(movieId) { type = NavType.StringType })
        )
        {
            backStackEntry -> val movieId = backStackEntry.arguments?.getString(movieId).toString()
            Log.d("Arg", movieId)
            DetailScreen( navController, movieId = movieId) }
    }
}