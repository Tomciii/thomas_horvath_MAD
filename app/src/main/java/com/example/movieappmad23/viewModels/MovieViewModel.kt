package com.example.movieappmad23.viewModels

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieappmad23.models.Genre
import com.example.movieappmad23.models.Movie
import com.example.movieappmad23.models.getMovies

class MovieViewModel : ViewModel() {
    private val _movieList = getMovies().toMutableStateList()

    val movies: List<Movie>
        get() = _movieList

    private val _favorites = getMovies().filter { x -> x.isFavorite }.toMutableStateList()
    val favorites: List<Movie>
        get() = _favorites

    private var _titleError: Boolean = false
    var titleError: Boolean
        get() = _titleError
        set(value) { _titleError = value }

    private val _titleErrorMessage = MutableLiveData<String>()
    val titleErrorMessage: LiveData<String>
        get() = _titleErrorMessage

    private var _yearError: Boolean = false
    var yearError: Boolean
        get() = _yearError
        set(value) { _yearError = value }

    private val _yearErrorMessage = MutableLiveData<String>()
    val yearErrorMessage: LiveData<String>
        get() = _yearErrorMessage

    private var _genreError: Boolean = false
    var genreError: Boolean
        get() = _genreError
        set(value) { _genreError = value }

    private val _genreErrorMessage = MutableLiveData<String>()
    val genreErrorMessage: LiveData<String>
        get() = _genreErrorMessage

    private var _directorError: Boolean = false
    var directorError: Boolean
        get() = _directorError
        set(value) { _directorError = value }

    private val _directorErrorMessage = MutableLiveData<String>()
    val directorErrorMessage: LiveData<String>
        get() = _directorErrorMessage

    private var _actorsError: Boolean = false
    var actorsError: Boolean
        get() = _actorsError
        set(value) { _actorsError = value }

    private val _actorsErrorMessage = MutableLiveData<String>()
    val actorsErrorMessage: LiveData<String>
        get() = _actorsErrorMessage

    private var _ratingError: Boolean = false
    var ratingError: Boolean
        get() = _ratingError
        set(value) { _ratingError = value }

    private val _ratingErrorMessage = MutableLiveData<String>()
    val ratingErrorMessage: LiveData<String>
        get() = _ratingErrorMessage

    private val _isAddButtonEnabled = MutableLiveData<Boolean>(false)
    val isAddButtonEnabled: LiveData<Boolean>
        get() = _isAddButtonEnabled

    fun validateTitle(title: String) {
        if (title.isEmpty()) {
            _titleErrorMessage.value = "Title cannot be empty"
            titleError = true
        } else {
            null
        }
        updateAddButtonState()
    }

    fun validateYear(year: String) {
        if (year.isEmpty()) {
            _yearErrorMessage.value = "Year cannot be empty"
            yearError = true
        } else {
            null
        }
        updateAddButtonState()
    }

    fun validateGenres(genres: List<Genre>) {
        if (genres.isEmpty()) {
            _genreErrorMessage.value = "At least one genre must be selected"
            genreError = true
        } else {
            null
        }
        updateAddButtonState()
    }

    fun validateDirector(director: String) {
        if (director.isEmpty()) {
            _directorErrorMessage.value = "Director cannot be empty"
            directorError = true
        } else {
            null
        }
        updateAddButtonState()
    }

    fun validateActors(actors: String) {
        if (actors.isEmpty()) {
            _actorsErrorMessage.value = "Actors cannot be empty"
            actorsError = true
        } else {
            null
        }
        updateAddButtonState()
    }

    fun validateRating(rating: Float) {
        if (rating <= 0) {
            _ratingErrorMessage.value = "Rating must be greater than 0"
            ratingError = true
        } else {
            null
        }
        updateAddButtonState()
    }

    private fun updateAddButtonState() {
        _isAddButtonEnabled.value = !(titleError && yearError && directorError && genreError && actorsError && ratingError)
    }

    fun markFavorite(movie: Movie) {
        movie.isFavorite = !movie.isFavorite
    }

    fun addMovie(movie: Movie){
        _movieList.add(movie)
    }
}