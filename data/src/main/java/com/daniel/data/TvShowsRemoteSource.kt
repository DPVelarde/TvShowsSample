package com.daniel.data

import com.daniel.data.model.Program
import com.daniel.data.model.Show
import kotlinx.coroutines.flow.Flow

interface TvShowsRemoteSource {
    fun getShowsSchedule(
        country: String,
        date: String
    ): Flow<List<Program>>

    fun getShowDetail(
        id: Int
    ): Flow<Show>

    fun search(
        query: String
    ): Flow<List<Show>>
}