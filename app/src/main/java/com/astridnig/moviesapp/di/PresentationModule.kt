package com.astridnig.moviesapp.di

import com.astridnig.moviesapp.di.DataModule.provideRepositoryImpl
import com.astridnig.moviesapp.presentation.moviedetail.factory.MovieDetailsViewModelFactory
import com.astridnig.moviesapp.presentation.movies.factory.MoviesViewModelFactory

object PresentationModule {
    val provideMoviesViewModelFactory: MoviesViewModelFactory by lazy {
        MoviesViewModelFactory(provideRepositoryImpl)
    }

    val provideMovieDetailsViewModelFactory: MovieDetailsViewModelFactory by lazy {
        MovieDetailsViewModelFactory(provideRepositoryImpl)
    }
}