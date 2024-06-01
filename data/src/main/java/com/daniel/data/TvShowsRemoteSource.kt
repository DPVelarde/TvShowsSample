package com.daniel.data

import com.daniel.data.model.ShowSchedule
import com.daniel.data.model.Show
import kotlinx.coroutines.flow.Flow

interface TvShowsRemoteSource {
    fun getShowsSchedule(
        country: String,
        date: String
    ): Flow<List<ShowSchedule>>

    fun getShowDetail(
        id: Int
    ): Flow<Show>

    fun search(
        query: String
    ): Flow<List<Show>>
}