package com.example.lectureexamples.screens

sealed class Screen(val route:String){
    object Home : Screen("homeScreen")
    object Detail : Screen("detailScreen")
}
