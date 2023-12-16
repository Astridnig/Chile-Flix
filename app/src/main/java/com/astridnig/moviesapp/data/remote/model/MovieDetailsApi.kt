package com.astridnig.moviesapp.data.remote.model

import com.astridnig.moviesapp.data.remote.model.Constants.ADULT
import com.astridnig.moviesapp.data.remote.model.Constants.BACKDROP_PATH
import com.astridnig.moviesapp.data.remote.model.Constants.BELONGS_TO_COLLECTION
import com.astridnig.moviesapp.data.remote.model.Constants.BUDGET
import com.astridnig.moviesapp.data.remote.model.Constants.GENRES
import com.astridnig.moviesapp.data.remote.model.Constants.HOMEPAGE
import com.astridnig.moviesapp.data.remote.model.Constants.ID
import com.astridnig.moviesapp.data.remote.model.Constants.IMDB_ID
import com.astridnig.moviesapp.data.remote.model.Constants.ORIGINAL_LANGUAGE
import com.astridnig.moviesapp.data.remote.model.Constants.ORIGINAL_TITLE
import com.astridnig.moviesapp.data.remote.model.Constants.OVERVIEW
import com.astridnig.moviesapp.data.remote.model.Constants.POPULARITY
import com.astridnig.moviesapp.data.remote.model.Constants.POSTER_PATH
import com.astridnig.moviesapp.data.remote.model.Constants.PRODUCTION_COMPANIES
import com.astridnig.moviesapp.data.remote.model.Constants.PRODUCTION_COUNTRIES
import com.astridnig.moviesapp.data.remote.model.Constants.RELEASE_DATE
import com.astridnig.moviesapp.data.remote.model.Constants.REVENUE
import com.astridnig.moviesapp.data.remote.model.Constants.RUNTIME
import com.astridnig.moviesapp.data.remote.model.Constants.SPOKEN_LANGUAGES
import com.astridnig.moviesapp.data.remote.model.Constants.STATUS
import com.astridnig.moviesapp.data.remote.model.Constants.TAGLINE
import com.astridnig.moviesapp.data.remote.model.Constants.TITLE
import com.astridnig.moviesapp.data.remote.model.Constants.VIDEO
import com.astridnig.moviesapp.data.remote.model.Constants.VOTE_AVERAGE
import com.astridnig.moviesapp.data.remote.model.Constants.VOTE_COUNT
import com.google.gson.annotations.SerializedName

data class MovieDetailsApi(
    @SerializedName(ADULT) val adult: Boolean?,
    @SerializedName(BACKDROP_PATH) val backdropPath: String?,
    @SerializedName(BELONGS_TO_COLLECTION) val belongsToCollection: BelongsToCollectionApiModel?,
    @SerializedName(BUDGET) val budget: Int?,
    @SerializedName(GENRES) val genres: List<GenreApiModel?>?,
    @SerializedName(HOMEPAGE) val homepage: String?,
    @SerializedName(ID) val id: Int?,
    @SerializedName(IMDB_ID) val imdbId: String?,
    @SerializedName(ORIGINAL_LANGUAGE) val originalLanguage: String?,
    @SerializedName(ORIGINAL_TITLE) val originalTitle: String?,
    @SerializedName(OVERVIEW) val overview: String?,
    @SerializedName(POPULARITY) val popularity: Double?,
    @SerializedName(POSTER_PATH) val posterPath: String?,
    @SerializedName(PRODUCTION_COMPANIES) val productionCompanies: List<ProductionCompaniesApiModel?>?,
    @SerializedName(PRODUCTION_COUNTRIES) val productionCountries: List<ProductionCountriesApiModel?>?,
    @SerializedName(RELEASE_DATE) val releaseDate: String?,
    @SerializedName(REVENUE) val revenue: Int?,
    @SerializedName(RUNTIME) val runtime: Int?,
    @SerializedName(SPOKEN_LANGUAGES) val spokenLanguages: List<SpokenLanguagesApiModel?>?,
    @SerializedName(STATUS) val status: String?,
    @SerializedName(TAGLINE) val tagline: String?,
    @SerializedName(TITLE) val title: String?,
    @SerializedName(VIDEO) val video: Boolean?,
    @SerializedName(VOTE_AVERAGE) val voteAverage: Double?,
    @SerializedName(VOTE_COUNT) val voteCount: Int?,
)
