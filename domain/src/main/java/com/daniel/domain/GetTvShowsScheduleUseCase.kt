package com.daniel.domain

import com.daniel.data.TvShowsRepository
import javax.inject.Inject

class GetTvShowsScheduleUseCase @Inject constructor(
    private val tvShowsRepository: TvShowsRepository
) {
    operator fun invoke(
        country: String,
        date: String
    ) = tvShowsRepository.getShowsSchedule(country, date)
}