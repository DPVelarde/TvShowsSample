package com.daniel.tvshowssample.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daniel.domain.SearchTvShowsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class TvShowsSearchViewModel @Inject constructor(
    private val searchTvShowsUseCase: SearchTvShowsUseCase
) : ViewModel() {
    var state = mutableStateOf(TvShowsSearchViewState())
        private set

    fun searchTvShows(query: String) {
        if (query.isEmpty()) return

        searchTvShowsUseCase(query)
            .onStart { state.value = TvShowsSearchViewState(isLoading = true) }
            .onEach {
                state.value = TvShowsSearchViewState(shows = it)
            }
            .catch { state.value = TvShowsSearchViewState(error = it) }
            .launchIn(viewModelScope)
    }
}