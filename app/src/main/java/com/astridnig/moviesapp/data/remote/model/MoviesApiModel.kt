package com.astridnig.moviesapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class MoviesApiModel(
    @SerializedName("page") val page: Int?,
    @SerializedName("results") val results: List<MovieApiModel?>?,
    @SerializedName("total_pages") val totalPages: Int?,
    @SerializedName("total_results") val totalResults: Int?
)
