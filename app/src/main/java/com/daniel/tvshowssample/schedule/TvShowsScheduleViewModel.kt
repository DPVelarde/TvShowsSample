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
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class TvShowsScheduleViewModel @Inject constructor(
    private val getTvShowsScheduleUseCase: GetTvShowsScheduleUseCase
) : ViewModel() {
    var state = mutableStateOf(TvShowsScheduleViewState())
        private set

    init {
        getTvShowsSchedule()
    }

    private fun getTvShowsSchedule() {
        val date = LocalDate.now()
        val dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE

        getTvShowsScheduleUseCase(dateTimeFormatter.format(date))
            .onStart { state.value = TvShowsScheduleViewState(isLoading = true) }
            .onEach {
                state.value = TvShowsScheduleViewState(showsSchedule = it)
            }
            .catch { state.value = TvShowsScheduleViewState(error = it) }
            .launchIn(viewModelScope)
    }
}