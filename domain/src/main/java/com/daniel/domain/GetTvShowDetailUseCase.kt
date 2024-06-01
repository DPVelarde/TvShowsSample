package com.daniel.domain

import com.daniel.data.TvShowsRepository
import javax.inject.Inject

class GetTvShowDetailUseCase @Inject constructor(
    private val tvShowsRepository: TvShowsRepository
) {
    operator fun invoke(id: Int) = tvShowsRepository.getShowDetail(id)
}