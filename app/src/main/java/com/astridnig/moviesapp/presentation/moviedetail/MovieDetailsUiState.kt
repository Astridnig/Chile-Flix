package com.astridnig.moviesapp.presentation.moviedetail

import com.astridnig.moviesapp.presentation.core.UiState
import com.astridnig.moviesapp.presentation.moviedetail.model.MovieDetails

sealed class MovieDetailsUiState : UiState {
    object LoadingUiState : MovieDetailsUiState()

    data class ShowMovieDetailsUiState(val movieDetails: MovieDetails) : MovieDetailsUiState()

    object ErrorUiState : MovieDetailsUiState()

}