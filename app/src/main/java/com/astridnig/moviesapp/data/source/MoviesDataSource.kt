package com.astridnig.moviesapp.data.source

import com.astridnig.moviesapp.data.remote.model.MovieDetailsApi
import com.astridnig.moviesapp.data.remote.model.MoviesApiModel

interface MoviesDataSource {
    suspend fun getMoviesPopular(
        page: Int,
        language: String
    ): MoviesApiModel

    suspend fun getMovieDetail(
        movieId: Int,
        language: String
    ): MovieDetailsApi
}