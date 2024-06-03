package com.daniel.tvshowssample.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.daniel.data.model.Show
import com.daniel.domain.GetTvShowDetailUseCase
import com.daniel.tvshowssample.util.MainDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TvShowDetailViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainTestDispatcherRule = MainDispatcherRule()

    @MockK
    private lateinit var getTvShowDetailUseCase: GetTvShowDetailUseCase

    private lateinit var viewModel: TvShowDetailViewModel

    @Before
    fun init() {
        MockKAnnotations.init(this)
        viewModel = TvShowDetailViewModel(getTvShowDetailUseCase)
    }

    @Test
    fun getTvShowDetail_SuccessResponse_ThenReturnShow() = runTest {
        val expected = mockk<Show>()
        every { getTvShowDetailUseCase.invoke(any()) } returns flowOf(expected)

        viewModel.getTvShowDetail(1)

        val state = viewModel.state.value
        assertFalse(state.error != null)
        assertFalse(state.isLoading)
        assertEquals(expected, state.show)
    }

    @Test
    fun getTvShowDetail_ErrorResponse_ThenReturnError() = runTest {
        val expected = Exception()
        every { getTvShowDetailUseCase.invoke(any()) } returns flow { throw expected }

        viewModel.getTvShowDetail(1)

        val state = viewModel.state.value
        assertFalse(state.show != null)
        assertFalse(state.isLoading)
        assertEquals(expected, state.error)
    }


}