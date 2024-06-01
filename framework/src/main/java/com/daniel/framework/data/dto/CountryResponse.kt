package com.daniel.framework.data.dto

import com.google.gson.annotations.SerializedName

internal data class CountryResponse(
    @SerializedName("code")
    val code: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("timezone")
    val timezone: String? = null
)