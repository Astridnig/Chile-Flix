package com.astridnig.moviesapp.presentation.repository

import com.astridnig.moviesapp.presentation.moviedetail.model.MovieDetails
import com.astridnig.moviesapp.presentation.movies.model.Movies


interface MoviesRepository {
    suspend fun getMoviesPopular(page: Int): Movies
    suspend fun getMovieDetail(movieId: Int): MovieDetails
}