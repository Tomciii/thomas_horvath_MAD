package com.example.lectureexamples.screens.composable

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.lectureexamples.models.Movie
import com.example.lectureexamples.util.MovieImage

@Composable
fun MovieRow(movie: Movie, onItemClick: (String) -> Unit = { Log.d("defa", "def") }) {
    val isClicked = remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { isClicked.value = !isClicked.value },
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        elevation = 5.dp
    ) {
        Column {
            Box(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            ) {

                MovieImage(movieImage = movie.images.get(0))

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Icon(
                        tint = MaterialTheme.colors.secondary,
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Add to favorites"
                    )
                }
            }

            MovieName(movie, isClicked)

                if (isClicked.value){
                    MovieAdditionalInformation(movie,isClicked)
                }
            }
        }
    }

@Composable
fun MovieAdditionalInformation(movie: Movie, isClicked: MutableState<Boolean>){
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
    }
}
    @Composable
    fun MovieName(movie: Movie, isClicked: MutableState<Boolean>){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(movie.title, style = MaterialTheme.typography.h6)

            if (isClicked.value){
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Show details"
                )
            } else{
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "Show details"
                )
            }
    }
}