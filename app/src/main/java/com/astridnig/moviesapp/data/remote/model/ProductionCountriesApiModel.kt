package com.astridnig.moviesapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class ProductionCountriesApiModel(
    @SerializedName("iso_3166_1") val iso: String?,
    @SerializedName("origin_country") val originCountry: String?
)
