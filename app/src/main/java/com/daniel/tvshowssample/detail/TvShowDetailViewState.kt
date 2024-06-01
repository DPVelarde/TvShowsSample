package com.daniel.tvshowssample.detail

import com.daniel.data.model.Show

data class TvShowDetailViewState(
    val isLoading: Boolean = false,
    val error: Throwable? = null,
    val show: Show? = null
)