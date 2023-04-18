package com.example.movieappmad23.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.movieappmad23.models.Movie
import com.example.movieappmad23.models.getMovies
import com.example.movieappmad23.utils.InjectorUtils
import com.example.movieappmad23.viewModels.FavoriteViewModel
import com.example.movieappmad23.widgets.MovieRow
import com.example.movieappmad23.widgets.SimpleTopAppBar
import kotlin.streams.toList

@Composable
fun FavoriteScreen(navController: NavController){

    val viewModel: FavoriteViewModel = viewModel(factory = InjectorUtils.provideDetailViewModelFactory(
        LocalContext.current))

    Scaffold(topBar = {
        SimpleTopAppBar(arrowBackClicked = { navController.popBackStack() }) {
            Text(text = "My Favorite Movies")
        }
    }){ padding ->
        val movieList: List<Movie> = getMovies()
            .stream()
            .filter{ it.isFavorite }
            .toList()

        Column(modifier = Modifier.padding(padding)) {
            LazyColumn {
                items(movieList){ movie ->
                    MovieRow(
                        movie = movie,
                        onItemClick = { movieId ->
                            navController.navigate(route = Screen.DetailScreen.withId(movieId))
                        }
                    )
                }
            }
        }
    }
}