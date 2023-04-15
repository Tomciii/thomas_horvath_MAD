package com.example.movieappmad23.viewModels

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.movieappmad23.models.Movie
import com.example.movieappmad23.models.getMovies

class FavoriteViewModel : ViewModel() {

    private val _favorites = getMovies().filter { x -> x.isFavorite }.toMutableStateList()
    val favorites: List<Movie>
        get() = _favorites

    fun markFavorite(movie: Movie) {
        movie.isFavorite = !movie.isFavorite
        if(movie.isFavorite)
            _favorites.add(movie)
        else if (_favorites.contains(movie))
            _favorites.remove(movie)
    }
}