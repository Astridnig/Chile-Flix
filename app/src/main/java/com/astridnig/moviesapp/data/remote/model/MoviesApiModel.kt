package com.astridnig.moviesapp.data.remote.model

import com.astridnig.moviesapp.data.remote.model.Constants.PAGE
import com.astridnig.moviesapp.data.remote.model.Constants.RESULTS
import com.astridnig.moviesapp.data.remote.model.Constants.TOTAL_PAGES
import com.astridnig.moviesapp.data.remote.model.Constants.TOTAL_RESULTS
import com.google.gson.annotations.SerializedName

data class MoviesApiModel(
    @SerializedName(PAGE) val page: Int?,
    @SerializedName(RESULTS) val results: List<MovieApiModel?>?,
    @SerializedName(TOTAL_PAGES) val totalPages: Int?,
    @SerializedName(TOTAL_RESULTS) val totalResults: Int?
)
