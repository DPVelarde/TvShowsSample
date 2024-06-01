package com.daniel.framework.data.dto

import com.google.gson.annotations.SerializedName

internal data class LinksResponse(
    @SerializedName("nextepisode")
    val nextEpisode: EpisodeResponse? = null,
    @SerializedName("previousepisode")
    val previousEpisode: EpisodeResponse? = null
)