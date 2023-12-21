package com.astridnig.moviesapp.data.remote.api.config

object UrlProvider {

    private const val BASE_URL = "https://api.themoviedb.org/3/movie/"

    fun getMoviesUrl() = BASE_URL
}