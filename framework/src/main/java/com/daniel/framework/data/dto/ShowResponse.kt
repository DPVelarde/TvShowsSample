package com.daniel.framework.data.dto

import com.google.gson.annotations.SerializedName

internal data class ShowResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("averageRuntime")
    val averageRuntime: Int,
    @SerializedName("ended")
    val ended: String? = null,
    @SerializedName("genres")
    val genres: List<String> = listOf(),
    @SerializedName("image")
    val image: ImageResponse? = null,
    @SerializedName("language")
    val language: String? = null,
    @SerializedName("links")
    val links: LinksResponse? = null,
    @SerializedName("network")
    val network: NetworkResponse? = null,
    @SerializedName("officialSite")
    val officialSite: String? = null,
    @SerializedName("premiered")
    val premiered: String? = null,
    @SerializedName("runtime")
    val runtime: Int,
    @SerializedName("schedule")
    val schedule: ScheduleResponse? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("summary")
    val summary: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("updated")
    val updated: Int? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("weight")
    val weight: Int? = null
)