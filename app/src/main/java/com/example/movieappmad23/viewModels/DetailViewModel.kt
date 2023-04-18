package com.example.movieappmad23.viewModels

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.movieappmad23.models.Movie
import com.example.movieappmad23.models.getMovies
import com.example.movieappmad23.repository.MovieRepository

class DetailViewModel(private val repository: MovieRepository) : ViewModel() {
    private val _movieList = getMovies().toMutableStateList()
    val movies: List<Movie>
        get() = _movieList

    fun getMovieById(id: Int):Movie{
        return repository.getMovieById(id)
    }
}