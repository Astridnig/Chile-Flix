package com.astridnig.moviesapp.presentation.movies.model

data class Movies(
    val page: Int,
    val results: List<Movie>,
    val totalPages: Int,
    val totalResults: Int
)
