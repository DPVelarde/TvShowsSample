package com.daniel.data.model

data class Show(
    val averageRuntime: Int,
    val ended: Any?,
    val genres: List<Any>,
    val id: Int,
    val image: Image,
    val language: String,
    val links: Links,
    val name: String,
    val network: Network,
    val officialSite: String,
    val premiered: String,
    val runtime: Int,
    val schedule: Schedule,
    val status: String,
    val summary: String,
    val type: String,
    val updated: Int
)