package com.example.movieappmad23.utils

import android.content.Context
import com.example.movieappmad23.data.MovieDatabase
import com.example.movieappmad23.repository.MovieRepository
import com.example.movieappmad23.viewModels.MovieViewModelFactory

object InjectorUtils {
    private fun getTaskRepository(context: Context): MovieRepository{
        return MovieRepository(MovieDatabase.getDatabse(context).movieDao())
    }

    fun provideTaskViewModelFactory(context: Context): MovieViewModelFactory {
        val repository = getTaskRepository(context)
        return MovieViewModelFactory(repository)
    }
}