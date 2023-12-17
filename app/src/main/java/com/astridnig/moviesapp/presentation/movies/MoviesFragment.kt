package com.astridnig.moviesapp.presentation.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.astridnig.moviesapp.databinding.FragmentMoviesBinding
import com.astridnig.moviesapp.di.PresentationModule.provideMoviesViewModelFactory
import com.astridnig.moviesapp.presentation.core.UiPresentation
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MoviesFragment : Fragment(), UiPresentation<MoviesUiState> {
    private var binding: FragmentMoviesBinding? = null
    private val viewModel: MoviesViewModel by viewModels { provideMoviesViewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUiStatesObserver()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null) {
            binding = FragmentMoviesBinding.inflate(inflater, container, false)
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        emitUiEvent(MoviesUiEvent.InitialUiEvent(page = 1))
    }

    private fun emitUiEvent(uiEvent: MoviesUiEvent) {
        lifecycleScope.launch {
            viewModel.processUiEvent(uiEvent)
        }
    }

    private fun setupUiStatesObserver() {
        with(viewModel) {
            uiState().onEach { renderUiStates(it) }.launchIn(lifecycleScope)
        }
    }

    override fun renderUiStates(uiState: MoviesUiState) {
        when (uiState) {
            MoviesUiState.ErrorUiState -> {
                showLoading(visible = false)
            }

            MoviesUiState.LoadingUiState -> {
                showLoading(visible = true)
            }

            is MoviesUiState.ShowMoviesUiState -> {
                showLoading(visible = false)
            }
        }
    }

    private fun showLoading(visible: Boolean) {
        if (visible) {
            binding?.progress?.isVisible = true
        } else {
            binding?.progress?.isGone = true
        }
    }
}