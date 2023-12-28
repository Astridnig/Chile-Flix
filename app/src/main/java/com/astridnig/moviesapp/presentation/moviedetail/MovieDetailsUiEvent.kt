package com.astridnig.moviesapp.presentation.moviedetail

import com.astridnig.moviesapp.presentation.core.UiEvent


sealed class MovieDetailsUiEvent : UiEvent {
    data class InitialUiEvent(val movieId: Int) : MovieDetailsUiEvent()
    data class RetryGetMovieDetailsUiEvent(val movieId: Int) : MovieDetailsUiEvent()
}