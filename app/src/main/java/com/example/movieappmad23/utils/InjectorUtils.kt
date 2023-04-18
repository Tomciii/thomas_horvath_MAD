package com.example.movieappmad23.utils

import android.content.Context
import com.example.movieappmad23.data.MovieDatabase
import com.example.movieappmad23.repository.MovieRepository
import com.example.movieappmad23.viewModels.factories.AddMovieViewModelFactory
import com.example.movieappmad23.viewModels.factories.DetailViewModelFactory
import com.example.movieappmad23.viewModels.factories.FavoriteViewModelFactory
import com.example.movieappmad23.viewModels.factories.HomeViewModelFactory

object InjectorUtils {
    private fun getMovieRepository(context: Context): MovieRepository{
        return MovieRepository(MovieDatabase.getDatabase(context).movieDao())
    }

    fun provideAddMovieViewModelFactory(context: Context): AddMovieViewModelFactory {
        val repository = getMovieRepository(context)
        return AddMovieViewModelFactory(repository)
    }

    fun provideDetailViewModelFactory(context: Context): DetailViewModelFactory {
        val repository = getMovieRepository(context)
        return DetailViewModelFactory(repository)
    }

    fun provideHomeViewModelFactory(context: Context): HomeViewModelFactory {
        val repository = getMovieRepository(context)
        return HomeViewModelFactory(repository)
    }

    fun provideFavoriteViewModelFactory(context: Context): FavoriteViewModelFactory {
        val repository = getMovieRepository(context)
        return FavoriteViewModelFactory(repository)
    }
}