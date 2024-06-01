package com.daniel.tvshowssample.schedule

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daniel.domain.GetTvShowsScheduleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class TvShowsScheduleViewModel @Inject constructor(
    private val getTvShowsScheduleUseCase: GetTvShowsScheduleUseCase
) : ViewModel() {

    var state = mutableStateOf(TvShowsScheduleViewState())
        private set

    fun getTvShowsSchedule() {
        getTvShowsScheduleUseCase(
            "US", "2024-05-31"
        )
            .onStart { state.value = TvShowsScheduleViewState(isLoading = true) }
            .onEach {
                state.value = TvShowsScheduleViewState(showsSchedule = it)
            }
            .catch { state.value = TvShowsScheduleViewState(error = it) }
            .launchIn(viewModelScope)
    }
}