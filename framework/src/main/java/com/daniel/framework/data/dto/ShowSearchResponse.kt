package com.daniel.framework.data.dto

internal data class ShowSearchResponse(
    val score: Double = 0.0,
    val show: ShowResponse
)