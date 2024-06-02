package com.daniel.domain

import com.daniel.data.TvShowsRepository
import javax.inject.Inject

class GetTvShowsScheduleUseCase @Inject constructor(
    private val tvShowsRepository: TvShowsRepository
) {
    operator fun invoke(
        date: String
    ) = tvShowsRepository.getShowsSchedule(US_COUNTRY, date)

    companion object {
        private const val US_COUNTRY = "US"
    }
}