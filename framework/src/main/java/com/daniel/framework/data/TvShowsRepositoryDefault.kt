package com.daniel.framework.data

import com.daniel.data.TvShowsRemoteSource
import com.daniel.data.TvShowsRepository
import com.daniel.data.model.Show
import com.daniel.data.model.ShowSchedule
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class TvShowsRepositoryDefault @Inject constructor(
    private val tvShowsRemoteSource: TvShowsRemoteSource,
    private val coroutineDispatcher: CoroutineDispatcher
) : TvShowsRepository {
    override fun getShowsSchedule(country: String, date: String): Flow<List<ShowSchedule>> {
        return tvShowsRemoteSource.getShowsSchedule(country, date)
            .flowOn(coroutineDispatcher)
    }

    override fun getShowDetail(id: Int): Flow<Show> {
        return tvShowsRemoteSource.getShowDetail(id)
            .flowOn(coroutineDispatcher)
    }

    override fun search(query: String): Flow<List<Show>> {
        return tvShowsRemoteSource.search(query)
            .flowOn(coroutineDispatcher)
    }
}