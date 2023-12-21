package com.astridnig.moviesapp.data.remote.api

import com.astridnig.moviesapp.data.remote.model.MovieDetailsApi
import com.astridnig.moviesapp.data.remote.model.MoviesApiModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET("popular")
    suspend fun getMoviesPopular(
        @Query("page") page: Int,
        @Query("language") language: String
    ): MoviesApiModel

    @GET("{movieId}")
    suspend fun getMovieDetail(
        @Path("movieId") movieId: Int,
        @Query("language") language: String
    ): MovieDetailsApi
}