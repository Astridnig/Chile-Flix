package com.astridnig.moviesapp.presentation.movies.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.astridnig.moviesapp.presentation.movies.MoviesViewModel
import com.astridnig.moviesapp.presentation.repository.MoviesRepository

class MoviesViewModelFactory(private val repository: MoviesRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            MoviesViewModel::class.java -> MoviesViewModel(repository)
            else -> throw ClassNotFoundException(
                "You should register your ViewModel here so as to create it"
            )
        } as T
    }
}

