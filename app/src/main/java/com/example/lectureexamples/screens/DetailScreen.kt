package com.example.lectureexamples.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.lectureexamples.models.Movie
import com.example.lectureexamples.screens.composable.TopAppBar

@Composable
fun DetailScreen(navController: NavController, movieId: String?) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column {
            TopAppBar(Screen.Detail.route, movieTitle = "Asdf")
        }
    }



}