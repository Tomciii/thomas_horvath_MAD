package com.example.lectureexamples.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lectureexamples.models.Movie
import com.example.lectureexamples.models.getMovies
import com.example.lectureexamples.screens.composable.MovieRow
import com.example.lectureexamples.screens.composable.TopAppBar
import com.example.lectureexamples.util.MovieImage

@Composable
fun DetailScreen(navController: NavController, movieId: String?) {

   val movie = getMovies().stream().filter { item -> item.id.equals(movieId) }.findFirst().get()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column {

            TopAppBar(Screen.Detail.route, movieTitle = movie.title)
            MovieRow(movie = movie, onItemClick = {})
            MovieAdditionalInformation(movie)
        }

    }
}

@Composable
fun MovieAdditionalInformation(movie: Movie){
       Column(modifier = Modifier.padding(17.dp)){

           Text("Director: " + movie.director)
           Text("Released: " + movie.year)
           Text("Genre: " + movie.genre)
           Text("Actors: " + movie.actors)
           Box(
               modifier = Modifier
                   .height(1.dp)
                   .fillMaxWidth()
                   .background(Color.Gray)

           )
           Text("Plot: " + movie.plot)
           Text("Rating: " + movie.rating)

           LazyRow {
               items(movie.images) { index -> MovieImage(movieImage = index)
           }
       }}
}