package com.example.lectureexamples.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.lectureexamples.models.getFavorites
import com.example.lectureexamples.screens.composable.FavoritesTopAppBar
import com.example.lectureexamples.screens.composable.MovieList

@Composable
fun FavoritesScreen(navController: NavController){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column {
            FavoritesTopAppBar(navController)
            MovieList(navController, getFavorites())
        }
    }
}