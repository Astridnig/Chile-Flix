package com.astridnig.moviesapp.data.remote.model

import com.astridnig.moviesapp.data.remote.model.Constants.ID
import com.astridnig.moviesapp.data.remote.model.Constants.LOGO_PATH
import com.astridnig.moviesapp.data.remote.model.Constants.NAME
import com.astridnig.moviesapp.data.remote.model.Constants.ORIGIN_COUNTRY
import com.google.gson.annotations.SerializedName

data class ProductionCompaniesApiModel(
    @SerializedName(ID) val id: Int?,
    @SerializedName(LOGO_PATH) val logoPath: String?,
    @SerializedName(NAME) val name: String?,
    @SerializedName(ORIGIN_COUNTRY) val originCountry: String?
)
