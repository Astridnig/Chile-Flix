package com.astridnig.moviesapp.data.remote.model

import com.astridnig.moviesapp.data.remote.model.Constants.ISO_3166_1
import com.astridnig.moviesapp.data.remote.model.Constants.ORIGIN_COUNTRY
import com.google.gson.annotations.SerializedName

data class ProductionCountriesApiModel(
    @SerializedName(ISO_3166_1) val iso: String?,
    @SerializedName(ORIGIN_COUNTRY) val originCountry: String?
)
