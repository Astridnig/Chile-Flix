package com.astridnig.moviesapp.presentation.movies

import androidx.lifecycle.ViewModel
import com.astridnig.moviesapp.presentation.core.ViewModelPresentation
import com.astridnig.moviesapp.presentation.repository.MoviesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MoviesViewModel(private val repository: MoviesRepository) : ViewModel(),
    ViewModelPresentation<MoviesUiEvent, MoviesUiState> {
    private val initialUiState: MoviesUiState = MoviesUiState.LoadingUiState
    private val uiState = MutableStateFlow(initialUiState)


    override fun processUiEvent(uiEvent: MoviesUiEvent) {
        when (uiEvent) {
            is MoviesUiEvent.InitialUiEvent -> {

            }

            is MoviesUiEvent.GetMoviesUiEvent -> {}
        }

    }

    override fun uiState(): StateFlow<MoviesUiState> = uiState.asStateFlow()


}