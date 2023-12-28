package com.astridnig.moviesapp.presentation.movies

import com.astridnig.moviesapp.presentation.core.UiState
import com.astridnig.moviesapp.presentation.movies.model.Movies

sealed class MoviesUiState : UiState {
    object LoadingUiState : MoviesUiState()

    data class ShowMoviesUiState(val movies: Movies) : MoviesUiState()

    data class ErrorUiState(val pageRetry: Int) : MoviesUiState()

}