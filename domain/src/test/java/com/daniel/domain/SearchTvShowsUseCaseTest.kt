package com.daniel.domain

import com.daniel.data.TvShowsRepository
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

class SearchTvShowsUseCaseTest {
    @MockK
    private lateinit var tvShowsRepository: TvShowsRepository

    lateinit var useCase: SearchTvShowsUseCase

    @Before
    fun init() {
        MockKAnnotations.init(this)

        useCase = SearchTvShowsUseCase(
            tvShowsRepository = tvShowsRepository
        )
    }

    @Test
    fun invoke_CallsCorrectRepositoryMethod() = runTest {
        coEvery { tvShowsRepository.search(any()) } returns flowOf(mockk())

        useCase("query").first()

        coVerify {
            tvShowsRepository.search("query")
        }
    }
}