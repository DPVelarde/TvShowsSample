package com.daniel.framework.data.dto

import com.google.gson.annotations.SerializedName

internal data class ImageResponse(
    @SerializedName("medium")
    val medium: String? = null,
    @SerializedName("original")
    val original: String? = null
)