package com.example.movieappmad23.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.movieappmad23.models.Movie
import com.example.movieappmad23.models.getMovies
import com.example.movieappmad23.utils.InjectorUtils
import com.example.movieappmad23.viewModels.DetailViewModel
import com.example.movieappmad23.widgets.HorizontalScrollableImageView
import com.example.movieappmad23.widgets.MovieRow
import com.example.movieappmad23.widgets.SimpleTopAppBar

fun filterMovie(movieId: String): Movie {
    return getMovies().filter { it.id.toString() == movieId}[0]
}
@Composable
fun DetailScreen(
    navController: NavController,
    movieId: String?
){
    val viewModel: DetailViewModel = viewModel(factory = InjectorUtils.provideDetailViewModelFactory(
        LocalContext.current))

    val coroutineScope = rememberCoroutineScope()

    movieId?.let {

        val movie = filterMovie(movieId = movieId.toString())

        // needed for show/hide snackbar
        val scaffoldState = rememberScaffoldState() // this contains the `SnackbarHostState`

        Scaffold(scaffoldState = scaffoldState, // attaching `scaffoldState` to the `Scaffold`
            topBar = {
                SimpleTopAppBar(arrowBackClicked = { navController.popBackStack() }) {
                    Text(text = movie.title)
                }
            },
        ) { padding ->
            MainContent(Modifier.padding(padding), movie)
        }
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier, movie: Movie) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            MovieRow(movie = movie)

            Spacer(modifier = Modifier.height(8.dp))

            Divider()

            Text(text = "Movie Images", style = MaterialTheme.typography.h5)

            HorizontalScrollableImageView(movie = movie)
        }
    }
}