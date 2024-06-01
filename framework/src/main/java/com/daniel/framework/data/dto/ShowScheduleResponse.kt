package com.daniel.framework.data.dto

import com.google.gson.annotations.SerializedName

internal data class ShowScheduleResponse(
    @SerializedName("airdate")
    val airdate: String,
    @SerializedName("airstamp")
    val airstamp: String? = null,
    @SerializedName("airtime")
    val airtime: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("number")
    val number: Int = 0,
    @SerializedName("runtime")
    val runtime: Int = 0,
    @SerializedName("season")
    val season: Int = 0,
    @SerializedName("show")
    val show: ShowResponse,
    @SerializedName("summary")
    val summary: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("url")
    val url: String? = null
)