package com.daniel.domain

import com.daniel.data.TvShowsRepository
import javax.inject.Inject

class SearchTvShowsUseCase @Inject constructor(
    private val tvShowsRepository: TvShowsRepository
) {
    operator fun invoke(query: String) = tvShowsRepository.search(query)
}