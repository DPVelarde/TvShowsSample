package com.daniel.framework.data

import com.daniel.data.TvShowsRemoteSource
import com.daniel.data.TvShowsRepository
import com.daniel.data.model.Show
import com.daniel.data.model.ShowSchedule
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class TvShowsRepositoryDefault @Inject constructor(
    private val tvShowsRemoteSource: TvShowsRemoteSource
) : TvShowsRepository {
    override fun getShowsSchedule(country: String, date: String): Flow<List<ShowSchedule>> {
        return tvShowsRemoteSource.getShowsSchedule(country, date)
    }

    override fun getShowDetail(id: Int): Flow<Show> {
        return tvShowsRemoteSource.getShowDetail(id)
    }

    override fun search(query: String): Flow<List<Show>> {
        return tvShowsRemoteSource.search(query)
    }
}