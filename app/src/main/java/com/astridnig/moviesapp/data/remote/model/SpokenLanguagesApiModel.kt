package com.astridnig.moviesapp.data.remote.model

import com.astridnig.moviesapp.data.remote.model.Constants.ENGLISH_NAME
import com.astridnig.moviesapp.data.remote.model.Constants.ISO_639_1
import com.astridnig.moviesapp.data.remote.model.Constants.NAME
import com.google.gson.annotations.SerializedName

data class SpokenLanguagesApiModel(
    @SerializedName(ENGLISH_NAME) val englishName: String?,
    @SerializedName(ISO_639_1) val iso: String?,
    @SerializedName(NAME) val name: String?
)
