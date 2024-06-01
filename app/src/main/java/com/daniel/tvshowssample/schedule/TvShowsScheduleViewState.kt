package com.daniel.tvshowssample.schedule

import com.daniel.data.model.ShowSchedule

data class TvShowsScheduleViewState(
    val isLoading: Boolean = false,
    val error: Throwable? = null,
    val showsSchedule: List<ShowSchedule>? = null
)