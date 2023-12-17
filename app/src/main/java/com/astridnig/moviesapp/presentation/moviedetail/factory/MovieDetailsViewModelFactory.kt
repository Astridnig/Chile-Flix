package com.astridnig.moviesapp.presentation.moviedetail.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.astridnig.moviesapp.presentation.moviedetail.model.MovieDetailsViewModel
import com.astridnig.moviesapp.presentation.repository.MoviesRepository

class MovieDetailsViewModelFactory(private val repository: MoviesRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            MovieDetailsViewModel::class.java -> MovieDetailsViewModel(repository)
            else -> throw ClassNotFoundException(
                "You should register your ViewModel here so as to create it"
            )
        } as T
    }
}

