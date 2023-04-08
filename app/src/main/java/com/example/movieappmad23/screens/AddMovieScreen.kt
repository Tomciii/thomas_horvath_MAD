package com.example.movieappmad23.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieappmad23.R
import com.example.movieappmad23.models.*
import com.example.movieappmad23.viewModels.MovieViewModel
import com.example.movieappmad23.widgets.SimpleTopAppBar

@Composable
fun AddMovieScreen(navController: NavController, movieViewModel: MovieViewModel){
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SimpleTopAppBar(arrowBackClicked = { navController.popBackStack() }) {
                Text(text = stringResource(id = R.string.add_movie))
            }
        },
    ) { padding ->
        MainContent(navController, Modifier.padding(padding))
    }
}


@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MainContent(navController: NavController, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(10.dp)
    ) {

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {

            var title by remember {
                mutableStateOf("")
            }

            var isValidTitle by remember {
                mutableStateOf(false)
            }

            var year by remember {
                mutableStateOf("")
            }

            var isValidYear by remember {
                mutableStateOf(false)
            }

            val genres = Genre.values().toList()

            var genreItems by remember {
                mutableStateOf(
                    genres.map { genre ->
                        ListItemSelectable(
                            title = genre.toString(),
                            isSelected = false
                        )
                    }
                )
            }

            var genreListIsEmpty by remember {
                mutableStateOf(genreItems.isEmpty())
            }

            var director by remember {
                mutableStateOf("")
            }

            var isValidDirector by remember {
                mutableStateOf(false)
            }

            var actors by remember {
                mutableStateOf("")
            }

            var isValidActor by remember {
                mutableStateOf(false)
            }

            var plot by remember {
                mutableStateOf("")
            }

            var isValidPlot by remember {
                mutableStateOf(false)
            }

            var rating by remember {
                mutableStateOf("")
            }

            var isValidRating by remember {
                mutableStateOf(false)
            }

            var isEnabledSaveButton by remember {
                mutableStateOf(false)
            }

            OutlinedTextField(
                value = title,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    title = it
                    isValidTitle = !title.isBlank()
                    isEnabledSaveButton = isValidTitle && isValidYear
                },
                label = {Text(text = stringResource(R.string.enter_movie_title))},
                isError = !isValidTitle,
                supportingText = { RequiredText(requiredText = R.string.title_required, textFieldIsFilled = isValidTitle)}
            )

            OutlinedTextField(
                value = year,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    year = it
                    isValidYear = !year.isBlank()
                    isEnabledSaveButton = isValidTitle && isValidYear && isValidActor && isValidDirector && isValidPlot && isValidRating
                },
                label = { Text(stringResource(R.string.enter_movie_year)) },
                isError = !isValidYear,
                supportingText = { RequiredText(requiredText = R.string.year_required, textFieldIsFilled = isValidYear)}
            )

            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = stringResource(R.string.select_genres),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h6)

            RequiredText(requiredText = R.string.genre_required, textFieldIsFilled = genreListIsEmpty)

            LazyHorizontalGrid(
                modifier = Modifier.height(100.dp),
                rows = GridCells.Fixed(3)){
                items(genreItems) { genreItem ->
                    Chip(
                        modifier = Modifier.padding(2.dp),
                        colors = ChipDefaults.chipColors(
                            backgroundColor = if (genreItem.isSelected)
                                colorResource(id = R.color.purple_200)
                            else
                                colorResource(id = R.color.white)
                        ),
                        onClick = {
                            genreItems = genreItems.map {
                                if (it.title == genreItem.title) {
                                    genreItem.copy(isSelected = !genreItem.isSelected)
                                } else {
                                    it
                                }
                            }

                            genreListIsEmpty = genreItems.isEmpty()
                        }
                    ) {
                        Text(text = genreItem.title)
                    }
                }
            }

            OutlinedTextField(
                value = director,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    director = it
                    isValidDirector = !director.isBlank()
                    isEnabledSaveButton = isValidTitle && isValidYear && isValidActor && isValidDirector && isValidPlot && isValidRating
                },
                label = { Text(stringResource(R.string.enter_director)) },
                isError = !isValidDirector,
                supportingText = { RequiredText(requiredText = R.string.director_required, textFieldIsFilled = isValidDirector)}
            )

            OutlinedTextField(
                value = actors,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    actors = it
                    isValidActor = !actors.isBlank()
                    isEnabledSaveButton = isValidTitle && isValidYear && isValidActor && isValidDirector && isValidPlot && isValidRating
                },
                label = { Text(stringResource(R.string.enter_actors)) },
                isError = !isValidActor,
                supportingText = { RequiredText(requiredText = R.string.actors_required, textFieldIsFilled = isValidActor)}
            )

            OutlinedTextField(
                value = plot,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                onValueChange = {
                    plot = it
                    isValidPlot = !plot.isBlank()
                    isEnabledSaveButton = isValidTitle && isValidYear && isValidActor && isValidDirector && isValidPlot && isValidRating
                },
                label = { Text(textAlign = TextAlign.Start, text = stringResource(R.string.enter_plot)) },
                isError = !isValidPlot,
                supportingText = { RequiredText(requiredText = R.string.plot_required, textFieldIsFilled = isValidPlot)}
            )

            OutlinedTextField(
                value = rating,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    rating = if(it.startsWith("0")) {
                        ""
                    } else {
                        it
                    }

                    isValidRating = rating.toFloatOrNull() != null
                    isEnabledSaveButton = isValidTitle && isValidYear && isValidActor && isValidDirector && isValidPlot && isValidRating
                },
                label = { Text(stringResource(R.string.enter_rating)) },
                isError = !isValidRating,
                supportingText = { RequiredText(requiredText = R.string.rating_required, textFieldIsFilled = isValidRating)}
            )

            Button(
                enabled = isEnabledSaveButton,
                onClick = {

                    val newMovie = Movie(
                        title = title,
                        year = year,
                        genre = genres,
                        director = director,
                        plot = plot,
                        rating = rating.toFloat(),
                        actors = actors,
                        id = title + year,
                        images = listOf("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Placeholder_view_vector.svg/681px-Placeholder_view_vector.svg.png")
                    )


                    addNewMovieToList(
                        title = title,
                        year = year,
                        genres = genres,
                        director = director,
                        plot = plot,
                        rating = rating,
                        actors = actors,
                        navController = navController
                    )

                }) {
                Text(text = stringResource(R.string.add))
            }
        }
    }
}

@Composable
fun RequiredText(requiredText:Int, textFieldIsFilled:Boolean){
    if(!textFieldIsFilled){
        Text(text=stringResource(requiredText),color=Color.Red)
    }
}

private fun addNewMovieToList(
    title: String,
    year: String,
    genres: List<Genre>,
    director: String,
    plot: String,
    rating: String,
    actors: String,
    navController:NavController
) {

    val newMovie = Movie(
        title = title,
        year = year,
        genre = genres,
        director = director,
        plot = plot,
        rating = rating.toFloat(),
        actors = actors,
        id = title + year,
        images = listOf("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Placeholder_view_vector.svg/681px-Placeholder_view_vector.svg.png")
    )

    moviesList = moviesList + newMovie
    navController.popBackStack()
}