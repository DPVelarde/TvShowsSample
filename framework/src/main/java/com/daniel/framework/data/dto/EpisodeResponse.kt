package com.daniel.framework.data.dto

import com.google.gson.annotations.SerializedName

internal data class EpisodeResponse(
    @SerializedName("href")
    val href: String = "",
    @SerializedName("name")
    val name: String = ""
)