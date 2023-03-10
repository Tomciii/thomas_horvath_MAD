package com.example.movieapp

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    MovieList()
                }
            }
        }
    }
}

@Composable
fun Movie(movieName: String, @DrawableRes image : Int){
    Card(){
        Column(modifier = Modifier.clip(shape = RoundedCornerShape(20.dp))) {
            MovieCard(image)
            MovieRow(movieName)
        }
    }
}

@Composable
fun MovieList(movieNames: List<String> = listOf("Avatar 1","Avatar 2", "Avatar 3"),
              @DrawableRes image : List<Int> = listOf(R.drawable.avatar,R.drawable.avatar, R.drawable.avatar)){

    LazyColumn{
   // items(movies){
  //      movie -> MovieRow(movie)
  //  }
    }

    Column{
    for(i in movieNames.indices){
        Movie(movieName = movieNames.get(i), image = image.get(i))
        }
    }
}

@Composable
fun MovieCard(@DrawableRes image : Int){
    val image = painterResource(image)

Box(
    modifier = Modifier
        .height(150.dp)
        .fillMaxWidth()
){
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.FillBounds
    )
    Box{
        Image(
            imageVector = Icons.Default.FavoriteBorder,
            contentDescription = "Add to favorites",
            contentScale = ContentScale.Crop
        )
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
            contentAlignment = Alignment.TopEnd
        ){
            Icon(
                tint = MaterialTheme.colors.secondary,
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "Add to favorites")
        }
    }

}
}

@Composable
fun MovieRow(movieName: String){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp), horizontalArrangement = Arrangement.SpaceBetween){
        Text(movieName)
        Icon(
            imageVector = Icons.Default.KeyboardArrowUp,
            contentDescription = "Show details")
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieAppTheme {
        Greeting("Android")
    }
}