package com.example.movieappmad23.utils

import android.content.Context
import com.example.movieappmad23.data.MovieDatabase
import com.example.movieappmad23.repository.MovieRepository
import com.example.movieappmad23.viewModels.MovieViewModelFactory

object InjectorUtils {
    private fun getMovieRepository(context: Context): MovieRepository{
        return MovieRepository(MovieDatabase.getDatabase(context).movieDao())
    }

    fun provideMovieViewModelFactory(context: Context): MovieViewModelFactory {
        val repository = getMovieRepository(context)
        return MovieViewModelFactory(repository)
    }
}