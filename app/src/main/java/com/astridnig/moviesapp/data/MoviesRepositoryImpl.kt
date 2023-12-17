package com.astridnig.moviesapp.data

import com.astridnig.moviesapp.data.mapper.MoviesMapper
import com.astridnig.moviesapp.data.source.MoviesDataSource
import com.astridnig.moviesapp.presentation.moviedetail.model.MovieDetails
import com.astridnig.moviesapp.presentation.movies.model.Movies
import com.astridnig.moviesapp.presentation.repository.MoviesRepository

class MoviesRepositoryImpl(
    private val remoteDataSource: MoviesDataSource,
    private val mapper: MoviesMapper
) : MoviesRepository {
    override suspend fun getMoviesPopular(page: Int): Movies {
        val moviesApiModel = remoteDataSource.getMoviesPopular(page = page, language = "es")
        return with(mapper) { moviesApiModel.toMovies() }
    }

    override suspend fun getMovieDetail(movieId: Int): MovieDetails {
        val movieDetailsApiModel =
            remoteDataSource.getMovieDetail(movieId = movieId, language = "es")
        return with(mapper) { movieDetailsApiModel.toMovieDetails() }
    }
}