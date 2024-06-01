package com.daniel.data.model

data class ShowSchedule(
    val id: Int,
    val name: String,
    val airDate: String,
    val airStamp: String,
    val airTime: String,
    val number: Int,
    val runtime: Int,
    val season: Int,
    val show: Show,
    val summary: String?,
    val type: String
)