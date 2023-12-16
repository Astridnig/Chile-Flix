package com.astridnig.moviesapp.data.remote.model

import com.astridnig.moviesapp.data.remote.model.Constants.ID
import com.astridnig.moviesapp.data.remote.model.Constants.NAME
import com.google.gson.annotations.SerializedName

data class GenreApiModel(
    @SerializedName(ID) val id: Int?,
    @SerializedName(NAME) val name: String?,
)
