package com.astridnig.moviesapp.presentation.moviedetail.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.astridnig.moviesapp.presentation.core.ViewModelPresentation
import com.astridnig.moviesapp.presentation.moviedetail.MovieDetailsUiEvent
import com.astridnig.moviesapp.presentation.moviedetail.MovieDetailsUiState
import com.astridnig.moviesapp.presentation.repository.MoviesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MovieDetailsViewModel(private val repository: MoviesRepository) : ViewModel(),
    ViewModelPresentation<MovieDetailsUiEvent, MovieDetailsUiState> {
    private val initialUiState: MovieDetailsUiState = MovieDetailsUiState.LoadingUiState
    private val uiState = MutableStateFlow(initialUiState)


    override fun processUiEvent(uiEvent: MovieDetailsUiEvent) {
        when (uiEvent) {
            is MovieDetailsUiEvent.InitialUiEvent -> {
                getMovieDetail(movieId = uiEvent.movieId)
            }
        }

    }

    override fun uiState(): StateFlow<MovieDetailsUiState> = uiState.asStateFlow()

    private fun getMovieDetail(movieId: Int) {
        uiState.update { MovieDetailsUiState.LoadingUiState }
        viewModelScope.launch {
            runCatching {
                repository.getMovieDetail(movieId = movieId)
            }.onSuccess { movieDetails ->
                uiState.update { MovieDetailsUiState.ShowMovieDetailsUiState(movieDetails = movieDetails) }
            }.onFailure {
                uiState.update { MovieDetailsUiState.ErrorUiState }
            }
        }
    }
}