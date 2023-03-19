package com.example.lectureexamples.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun MovieImage(movieImage: String){
    Box(){
 val painter = rememberImagePainter(
            data = movieImage,
            builder = {}
        )
        Image(
            painter = painter,
            contentDescription = "Movie Poster",
            contentScale = ContentScale.Crop
        )
}
}