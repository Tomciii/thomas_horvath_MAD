package com.example.movieappmad23.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Button
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.navigation.NavController
import com.example.movieappmad23.R
import com.example.movieappmad23.models.*
import com.example.movieappmad23.viewModels.MovieViewModel
import com.example.movieappmad23.widgets.SimpleTopAppBar
import java.util.*

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
        MainContent(Modifier.padding(padding), movieViewModel = movieViewModel, navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun MainContent(modifier: Modifier = Modifier, movieViewModel: MovieViewModel, navController: NavController) {
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

            var year by remember {
                mutableStateOf("")
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

            var director by remember {
                mutableStateOf("")
            }

            var actors by remember {
                mutableStateOf("")
            }

            var plot by remember {
                mutableStateOf("")
            }

            var rating by remember {
                mutableStateOf("")
            }

            OutlinedTextField(
                value = title,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    title = it
                    movieViewModel.validateTitle(title)
                },
                label = { Text(text = stringResource(R.string.enter_movie_title)) },
                isError = movieViewModel.titleError.value!!,
                supportingText = { RequiredText(requiredText = R.string.title_required, textFieldIsFilled = title.isNotBlank()) }
            )

            OutlinedTextField(
                value = year,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    year = it
                    movieViewModel.validateYear(year)
                },
                label = { Text(stringResource(R.string.enter_movie_year)) },
                isError = movieViewModel.yearError.value!!,
                supportingText = { RequiredText(requiredText = R.string.year_required, textFieldIsFilled = year.isNotBlank()) }
            )

            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = stringResource(R.string.select_genres),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.headlineSmall
            )

            LazyHorizontalGrid(
                modifier = Modifier.height(100.dp),
                rows = GridCells.Fixed(3)
            ) {
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
                            movieViewModel.validateGenres(genreItems)
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
                    movieViewModel.validateDirector(director)
                },
                label = { Text(stringResource(R.string.enter_director)) },
                isError = movieViewModel.directorError.value!!,
                supportingText = { RequiredText(requiredText = R.string.director_required, textFieldIsFilled = director.isNotBlank()) }
            )

            OutlinedTextField(
                value = actors,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    actors = it
                    movieViewModel.validateActors(actors)
                },
                label = { Text(stringResource(R.string.enter_actors)) },
                isError = movieViewModel.actorsError.value!!,
                supportingText = { RequiredText(requiredText = R.string.actors_required, textFieldIsFilled = actors.isNotBlank()) }
            )

            OutlinedTextField(
                value = plot,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                onValueChange = { plot = it },
                label = {
                    Text(
                        textAlign = TextAlign.Start,
                        text = stringResource(R.string.enter_plot)
                    )
                },
                isError = false
            )

            OutlinedTextField(
                value = rating,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    rating = if (it.startsWith("0")) {
                        ""
                    } else {
                        it
                    }

                    if (rating.toFloatOrNull() != null)
                        movieViewModel.validateRating(rating.toFloat())
                },
                label = { Text(stringResource(R.string.enter_rating)) },
                isError = movieViewModel.ratingError.value!!,
                supportingText = { RequiredText(requiredText = R.string.rating_required, textFieldIsFilled = rating.isNotBlank()) }
            )

            Button(
                enabled = movieViewModel.isAddButtonEnabled.value as Boolean,
                onClick = {
                    val images =
                        listOf("https://images-na.ssl-images-amazon.com/images/M/MV5BNzM2MDk3MTcyMV5BMl5BanBnXkFtZTcwNjg0MTUzNA@@._V1_SX1777_CR0,0,1777,999_AL_.jpg")
                    val movie = Movie(
                        UUID.randomUUID().toString(),
                        title,
                        year,
                        genres,
                        director,
                        actors,
                        plot,
                        images,
                        rating.toFloatOrNull() ?: 0F
                    )
                    movieViewModel.addMovie(movie)
                    navController.popBackStack()
                }) { Text(text = stringResource(R.string.add))
            }
        }
    }
}

@Composable
fun RequiredText(requiredText:Int, textFieldIsFilled:Boolean){
    if(!textFieldIsFilled){
        Text(text=stringResource(requiredText),color= Color.Red)
    }
}