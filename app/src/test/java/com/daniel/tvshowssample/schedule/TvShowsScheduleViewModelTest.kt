package com.daniel.tvshowssample.schedule

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.daniel.data.model.ShowSchedule
import com.daniel.domain.GetTvShowsScheduleUseCase
import com.daniel.tvshowssample.util.MainDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import junit.framework.TestCase
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class TvShowsScheduleViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainTestDispatcherRule = MainDispatcherRule()

    @MockK
    private lateinit var getTvShowsScheduleUseCase: GetTvShowsScheduleUseCase

    private lateinit var viewModel: TvShowsScheduleViewModel

    @Before
    fun init() {
        MockKAnnotations.init(this)

        every { getTvShowsScheduleUseCase(any()) } returns flowOf(mockk())

        viewModel = TvShowsScheduleViewModel(getTvShowsScheduleUseCase)
    }

    @Test
    fun reload_SuccessResponse_ThenReturnShow() = runTest {
        val expected = mockk<List<ShowSchedule>>()
        every { getTvShowsScheduleUseCase(any()) } returns flowOf(expected)

        val dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE
        val date = LocalDate.now()
        val expectedDate = dateTimeFormatter.format(date)

        viewModel.reload()

        val state = viewModel.state.value
        TestCase.assertFalse(state.error != null)
        TestCase.assertFalse(state.isLoading)
        TestCase.assertEquals(expectedDate, state.selectedDate)
        TestCase.assertEquals(expected, state.showsSchedule)
    }

    @Test
    fun reload_ErrorResponse_ThenReturnShow() = runTest {
        val expected = Exception()
        every { getTvShowsScheduleUseCase(any()) } returns flow { throw expected }

        viewModel.reload()

        val state = viewModel.state.value
        TestCase.assertEquals(expected, state.error)
        TestCase.assertFalse(state.isLoading)
        TestCase.assertFalse(state.showsSchedule != null)
    }

    @Test
    fun updateSelectedDate_SuccessResponse_ThenReturnShow() = runTest {
        val dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE
        val date = LocalDate.of(2024, 8, 27)
        val expectedDate = dateTimeFormatter.format(date)

        viewModel.updateSelectedDate(
            date.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
        )

        val state = viewModel.state.value
        TestCase.assertFalse(state.error != null)
        TestCase.assertFalse(state.isLoading)
        TestCase.assertEquals(expectedDate, state.selectedDate)
    }

    @Test
    fun dateValidator_DateGreaterThanNow_ThenReturnFalse() = runTest {
        val result = viewModel.dateValidator(Instant.now().plusSeconds(84600L).toEpochMilli())

        assertFalse(result)
    }

    @Test
    fun dateValidator_DateLessThanNow_ThenReturnFalse() = runTest {
        val result = viewModel.dateValidator(Instant.now().minusMillis(84600L).toEpochMilli())

        assertTrue(result)
    }

}