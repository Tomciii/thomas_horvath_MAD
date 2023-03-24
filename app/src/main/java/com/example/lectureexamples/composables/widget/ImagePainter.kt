package com.example.lectureexamples.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter

@Composable
fun ImagePainter(movieImage: String){
    Box(){
 val painter = rememberImagePainter(
            data = movieImage,
            builder = {}
        )
        Image(
            painter = painter,
            contentDescription = "image",
            contentScale = ContentScale.Crop)
    }
}