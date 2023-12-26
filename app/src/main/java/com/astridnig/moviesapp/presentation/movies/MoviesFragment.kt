package com.astridnig.moviesapp.presentation.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.astridnig.moviesapp.R
import com.astridnig.moviesapp.databinding.FragmentMoviesBinding
import com.astridnig.moviesapp.di.PresentationModule.provideMoviesViewModelFactory
import com.astridnig.moviesapp.presentation.core.UiPresentation
import com.astridnig.moviesapp.presentation.movies.adapter.MoviesAdapter
import com.astridnig.moviesapp.presentation.movies.model.Movie
import com.astridnig.moviesapp.presentation.movies.model.Movies
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
        if (viewModel.uiState().value == MoviesUiState.LoadingUiState) {
            emitUiEvent(MoviesUiEvent.InitialUiEvent(page = 1))
        }
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
            is MoviesUiState.ErrorUiState -> {
                showLoading(visible = false)
                showError(visible = true)
            }

            MoviesUiState.LoadingUiState -> {
                showLoading(visible = true)
                showError(visible = false)
            }

            is MoviesUiState.ShowMoviesUiState -> {
                showLoading(visible = false)
                setPagination(movies = uiState.movies)
                showListMovies(movies = uiState.movies.results)
            }
        }
    }

    private fun showListMovies(movies: List<Movie>) {
        context?.let { safeContext ->
            val moviesAdapter =
                MoviesAdapter(context = safeContext, movies = movies) { movieId ->
                    val bundle = Bundle()
                    bundle.putInt("movieId", movieId)
                    view?.findNavController()?.navigate(
                        R.id.action_moviesFragment_to_movieDetailFragment,
                        bundle
                    )
                }
            binding?.rvMovies?.isVisible = true
            binding?.rvMovies?.apply {
                adapter = moviesAdapter
                layoutManager = LinearLayoutManager(context)
                isVisible = true
            }
        }
    }

    private fun setPagination(movies: Movies) {
        binding?.let {
            when (movies.page) {
                1 -> {
                    it.buttonPrev.isInvisible = true
                    it.buttonNext.isVisible = true
                }
                movies.totalPages -> {
                    it.buttonPrev.isVisible = true
                    it.buttonNext.isInvisible = true
                }
                else -> {
                    it.buttonPrev.isVisible = true
                    it.buttonNext.isVisible = true
                }
            }
            it.textPagination.text = "Página ${movies.page}"

            it.buttonNext.setOnClickListener {
                emitUiEvent(MoviesUiEvent.GetMoviesUiEvent(page = movies.page + 1))

            }
            it.buttonPrev.setOnClickListener {
                emitUiEvent(MoviesUiEvent.GetMoviesUiEvent(page = movies.page - 1))
            }
        }
    }

    private fun showLoading(visible: Boolean) {
        binding?.let {
            if (visible) {
                it.progress.isVisible = true
            } else {
                it.progress.isGone = true
            }
        }
    }

    private fun showError(visible: Boolean, pageRetry: Int = 1) {
        binding?.let {
            if (visible) {
                it.rvMovies.isInvisible = true
                it.linearError.isVisible = true
                it.buttonRetry.setOnClickListener {
                    emitUiEvent(MoviesUiEvent.GetMoviesUiEvent(page = pageRetry))
                }
            } else {
                it.linearError.isGone = true
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}