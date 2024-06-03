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
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class TvShowsScheduleViewModel @Inject constructor(
    private val getTvShowsScheduleUseCase: GetTvShowsScheduleUseCase
) : ViewModel() {
    private var selectedDate: String = getDefaultDate()

    var state = mutableStateOf(TvShowsScheduleViewState(selectedDate = selectedDate))
        private set

    init {
        reload()
    }

    fun reload() {
        getTvShowsSchedule(selectedDate)
    }

    private fun getDefaultDate(): String {
        val dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE
        val date = LocalDate.now()
        return dateTimeFormatter.format(date)
    }

    fun updateSelectedDate(dateLong: Long) {
        val dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE
        val localDate = Instant.ofEpochMilli(dateLong).atZone(ZoneOffset.UTC).toLocalDate()
        selectedDate = dateTimeFormatter.format(localDate)
        getTvShowsSchedule(selectedDate)
    }

    private fun getTvShowsSchedule(selectedDate: String) {
        getTvShowsScheduleUseCase(selectedDate)
            .onStart { state.value = TvShowsScheduleViewState(isLoading = true) }
            .onEach {
                state.value = TvShowsScheduleViewState(
                    showsSchedule = it,
                    selectedDate = selectedDate
                )
            }
            .catch { state.value = TvShowsScheduleViewState(error = it) }
            .launchIn(viewModelScope)
    }

    fun dateValidator(date: Long): Boolean {
        return Instant.now().toEpochMilli() > date
    }

}