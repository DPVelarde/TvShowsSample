package com.daniel.framework.data

import com.daniel.data.TvShowsRemoteSource
import com.daniel.data.model.ShowSchedule
import com.daniel.data.model.Show
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class TvShowsMazeSource @Inject constructor(
    private val tvSHowsApi: TvShowsApi,
    private val tvShowsMapper: TvShowsMapper
) : TvShowsRemoteSource {
    override fun getShowsSchedule(country: String, date: String): Flow<List<ShowSchedule>> = flow {
        emit(tvShowsMapper.showsScheduleResponseToModel(tvSHowsApi.getShowsSchedule(country, date)))
    }

    override fun getShowDetail(id: Int): Flow<Show> = flow {
        emit(tvShowsMapper.showDetailResponseToModel(tvSHowsApi.getShowDetail(id)))
    }

    override fun search(query: String): Flow<List<Show>> {
        TODO("Not yet implemented")
    }
}