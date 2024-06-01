package com.daniel.data.model

data class Show(
    val id: Int,
    val name: String,
    val image: Image,
    val averageRuntime: Int? = null,
    val ended: String? = null,
    val genres: List<String>? = null,
    val language: String? = null,
    val links: Links? = null,
    val network: Network? = null,
    val officialSite: String? = null,
    val premiered: String? = null,
    val runtime: Int? = null,
    val schedule: Schedule? = null,
    val status: String? = null,
    val summary: String? = null,
    val type: String? = null,
    val updated: Int? = null
)