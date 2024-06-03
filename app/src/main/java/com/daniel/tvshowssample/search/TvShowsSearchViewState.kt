package com.daniel.tvshowssample.search

import com.daniel.data.model.Show

data class TvShowsSearchViewState(
    val isLoading: Boolean = false,
    val error: Throwable? = null,
    val shows: List<Show>? = null
)