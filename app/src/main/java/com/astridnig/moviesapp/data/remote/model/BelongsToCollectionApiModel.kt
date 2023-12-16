package com.astridnig.moviesapp.data.remote.model

import com.astridnig.moviesapp.data.remote.model.Constants.BACKDROP_PATH
import com.astridnig.moviesapp.data.remote.model.Constants.ID
import com.astridnig.moviesapp.data.remote.model.Constants.NAME
import com.astridnig.moviesapp.data.remote.model.Constants.POSTER_PATH
import com.google.gson.annotations.SerializedName

data class BelongsToCollectionApiModel(
    @SerializedName(ID) val id: Int?,
    @SerializedName(NAME) val name: String?,
    @SerializedName(POSTER_PATH) val posterPath: String?,
    @SerializedName(BACKDROP_PATH) val backdropPath: String?,
)
