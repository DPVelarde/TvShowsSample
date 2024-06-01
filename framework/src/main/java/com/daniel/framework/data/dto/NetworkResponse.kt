package com.daniel.framework.data.dto

import com.google.gson.annotations.SerializedName

internal data class NetworkResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("country")
    val country: CountryResponse? = null,
    @SerializedName("officialSite")
    val officialSite: String? = null
)