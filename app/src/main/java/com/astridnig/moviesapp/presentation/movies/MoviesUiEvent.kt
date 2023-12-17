package com.astridnig.moviesapp.presentation.movies

import com.astridnig.moviesapp.presentation.core.UiEvent


sealed class MoviesUiEvent : UiEvent {
    data class InitialUiEvent(val page: Int) : MoviesUiEvent()
    data class GetMoviesUiEvent(val page: Int) : MoviesUiEvent()
}