package com.astridnig.moviesapp.presentation.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.astridnig.moviesapp.databinding.FragmentMovieDetailBinding
import com.astridnig.moviesapp.di.PresentationModule.provideMovieDetailsViewModelFactory
import com.astridnig.moviesapp.presentation.core.UiPresentation
import com.astridnig.moviesapp.presentation.moviedetail.model.MovieDetails
import com.astridnig.moviesapp.presentation.moviedetail.model.MovieDetailsViewModel
import com.bumptech.glide.Glide
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MovieDetailFragment : Fragment(), UiPresentation<MovieDetailsUiState> {
    private var binding: FragmentMovieDetailBinding? = null
    private val viewModel: MovieDetailsViewModel by viewModels { provideMovieDetailsViewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUiStatesObserver()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null) {
            binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val movieId = it.getInt("movieId")
            emitUiEvent(MovieDetailsUiEvent.InitialUiEvent(movieId = movieId))
        }
    }

    private fun emitUiEvent(uiEvent: MovieDetailsUiEvent) {
        lifecycleScope.launch {
            viewModel.processUiEvent(uiEvent)
        }
    }

    private fun setupUiStatesObserver() {
        with(viewModel) {
            uiState().onEach { renderUiStates(it) }.launchIn(lifecycleScope)
        }
    }

    override fun renderUiStates(uiState: MovieDetailsUiState) {
        when (uiState) {
            MovieDetailsUiState.ErrorUiState -> {
                showLoading(visible = false)
            }

            MovieDetailsUiState.LoadingUiState -> {
                showLoading(visible = true)
            }

            is MovieDetailsUiState.ShowMovieDetailsUiState -> {
                showLoading(visible = false)
                drawMovieDetails(movieDetails = uiState.movieDetails)
            }
        }
    }

    private fun drawMovieDetails(movieDetails: MovieDetails) {
        binding?.let {
            it.title.text = movieDetails.title
            it.overview.text = movieDetails.overview
            Glide.with(it.root)
                .load("https://image.tmdb.org/t/p/w440_and_h660_face/" + movieDetails.posterPath)
                .into(it.imagePoster)
        }
    }

    private fun showLoading(visible: Boolean) {
        if (visible) {
            binding?.progress?.isVisible = true
        } else {
            binding?.progress?.isGone = true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}