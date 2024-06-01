package com.daniel.framework.data.dto

import com.google.gson.annotations.SerializedName

internal data class ScheduleResponse(
    @SerializedName("days")
    val days: List<String> = listOf(),
    @SerializedName("time")
    val time: String
)