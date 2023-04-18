package com.example.movieappmad23.viewModels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieappmad23.repository.MovieRepository
import com.example.movieappmad23.viewModels.DetailViewModel
import com.example.movieappmad23.viewModels.FavoriteViewModel

class FavoriteViewModelFactory (private val repository: MovieRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FavoriteViewModel::class.java)){
            return FavoriteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}