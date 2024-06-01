package com.daniel.tvshowssample.detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daniel.domain.GetTvShowDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class TvShowDetailViewModel @Inject constructor(
    private val getTvShowDetailUseCase: GetTvShowDetailUseCase
) : ViewModel() {

    var state = mutableStateOf(TvShowDetailViewState())
        private set

    fun getTvShowsSchedule(id: Int) {
        getTvShowDetailUseCase(id)
            .onStart { state.value = TvShowDetailViewState(isLoading = true) }
            .onEach {
                state.value = TvShowDetailViewState(showsSchedule = it)
            }
            .catch { state.value = TvShowDetailViewState(error = it) }
            .launchIn(viewModelScope)
    }
}