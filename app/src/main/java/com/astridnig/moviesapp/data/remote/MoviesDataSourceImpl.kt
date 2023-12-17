package com.astridnig.moviesapp.data.remote

import com.astridnig.moviesapp.data.remote.api.MoviesApi
import com.astridnig.moviesapp.data.remote.model.MovieDetailsApi
import com.astridnig.moviesapp.data.remote.model.MoviesApiModel
import com.astridnig.moviesapp.data.source.MoviesDataSource

class MoviesDataSourceImpl constructor(private val api: MoviesApi) : MoviesDataSource {
    override suspend fun getMoviesPopular(page: Int, language: String): MoviesApiModel {
        return api.getMoviesPopular(page = page, language = language)
    }

    override suspend fun getMovieDetail(movieId: Int, language: String): MovieDetailsApi {
        return api.getMovieDetail(language = language, movieId = movieId)
    }

}