package com.astridnig.moviesapp.data.remote.model

import com.astridnig.moviesapp.data.remote.model.Constants.ADULT
import com.astridnig.moviesapp.data.remote.model.Constants.BACKDROP_PATH
import com.astridnig.moviesapp.data.remote.model.Constants.GENRE_IDS
import com.astridnig.moviesapp.data.remote.model.Constants.ID
import com.astridnig.moviesapp.data.remote.model.Constants.ORIGINAL_LANGUAGE
import com.astridnig.moviesapp.data.remote.model.Constants.ORIGINAL_TITLE
import com.astridnig.moviesapp.data.remote.model.Constants.OVERVIEW
import com.astridnig.moviesapp.data.remote.model.Constants.POPULARITY
import com.astridnig.moviesapp.data.remote.model.Constants.POSTER_PATH
import com.astridnig.moviesapp.data.remote.model.Constants.RELEASE_DATE
import com.astridnig.moviesapp.data.remote.model.Constants.TITLE
import com.astridnig.moviesapp.data.remote.model.Constants.VIDEO
import com.astridnig.moviesapp.data.remote.model.Constants.VOTE_AVERAGE
import com.astridnig.moviesapp.data.remote.model.Constants.VOTE_COUNT
import com.google.gson.annotations.SerializedName

data class MovieApiModel(
    @SerializedName(ADULT) val adult: Boolean?,
    @SerializedName(BACKDROP_PATH) val backdropPath: String?,
    @SerializedName(GENRE_IDS) val genreIds: List<Int?>?,
    @SerializedName(ID) val id: Int?,
    @SerializedName(ORIGINAL_LANGUAGE) val originalLanguage: String?,
    @SerializedName(ORIGINAL_TITLE) val originalTitle: String?,
    @SerializedName(OVERVIEW) val overview: String?,
    @SerializedName(POPULARITY) val popularity: Double?,
    @SerializedName(POSTER_PATH) val posterPath: String?,
    @SerializedName(RELEASE_DATE) val releaseDate: String?,
    @SerializedName(TITLE) val title: String?,
    @SerializedName(VIDEO) val video: Boolean?,
    @SerializedName(VOTE_AVERAGE) val voteAverage: Double?,
    @SerializedName(VOTE_COUNT) val voteCount: Int?
)
