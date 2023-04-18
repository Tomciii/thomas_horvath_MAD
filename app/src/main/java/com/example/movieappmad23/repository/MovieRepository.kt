package com.example.movieappmad23.repository

import com.example.movieappmad23.data.MovieDao
import com.example.movieappmad23.models.Movie

class MovieRepository(private val movieDao: MovieDao){
    suspend fun add(movie: Movie) = movieDao.add(movie)

    suspend fun  delete(movie: Movie) = movieDao.delete(movie)

    suspend fun update(movie: Movie) = movieDao.update(movie)

    fun getMovies() = movieDao.readAll()

    fun getMovieById(id: Int) = movieDao.getMovieById(id)

    fun getFavoriteMovies() = movieDao.readFavoriteMovies()
}