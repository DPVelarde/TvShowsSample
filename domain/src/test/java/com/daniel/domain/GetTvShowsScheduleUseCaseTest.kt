package com.daniel.domain

import com.daniel.data.TvShowsRepository
import com.daniel.domain.GetTvShowsScheduleUseCase.Companion.US_COUNTRY
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetTvShowsScheduleUseCaseTest {
    @MockK
    private lateinit var tvShowsRepository: TvShowsRepository

    lateinit var useCase: GetTvShowsScheduleUseCase

    @Before
    fun init() {
        MockKAnnotations.init(this)

        useCase = GetTvShowsScheduleUseCase(
            tvShowsRepository = tvShowsRepository
        )
    }

    @Test
    fun invoke_CallsCorrectRepositoryMethod() = runTest {
        coEvery { tvShowsRepository.getShowsSchedule(any(), any()) } returns flowOf(mockk())

        useCase("2024-05-31").first()

        coVerify {
            tvShowsRepository.getShowsSchedule(US_COUNTRY, "2024-05-31")
        }
    }
}