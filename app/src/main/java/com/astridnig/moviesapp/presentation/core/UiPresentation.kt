package com.astridnig.moviesapp.presentation.core

interface UiPresentation <TUiState: UiState> {
    fun renderUiStates(uiState: TUiState)
}