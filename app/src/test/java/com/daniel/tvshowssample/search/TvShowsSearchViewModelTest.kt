package com.daniel.tvshowssample.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.daniel.data.model.Show
import com.daniel.domain.SearchTvShowsUseCase
import com.daniel.tvshowssample.util.MainDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import junit.framework.TestCase
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TvShowsSearchViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainTestDispatcherRule = MainDispatcherRule()

    @MockK
    private lateinit var searchTvShowsUseCase: SearchTvShowsUseCase

    private lateinit var viewModel: TvShowsSearchViewModel

    @Before
    fun init() {
        MockKAnnotations.init(this)
        viewModel = TvShowsSearchViewModel(searchTvShowsUseCase)
    }

    @Test
    fun getTvShowDetail_SuccessResponse_ThenReturnShow() = runTest {
        val expected = mockk<List<Show>>()
        every { searchTvShowsUseCase.invoke(any()) } returns flowOf(expected)

        viewModel.searchTvShows("query")

        val state = viewModel.state.value
        TestCase.assertFalse(state.error != null)
        TestCase.assertFalse(state.isLoading)
        TestCase.assertEquals(expected, state.shows)
    }

    @Test
    fun getTvShowDetail_ErrorResponse_ThenReturnError() = runTest {
        val expected = Exception()
        every { searchTvShowsUseCase.invoke(any()) } returns flow { throw expected }

        viewModel.searchTvShows("query")

        val state = viewModel.state.value
        TestCase.assertFalse(state.shows != null)
        TestCase.assertFalse(state.isLoading)
        TestCase.assertEquals(expected, state.error)
    }


}