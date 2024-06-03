package com.daniel.framework.data

import com.daniel.data.TvShowsRemoteSource
import com.daniel.data.TvShowsRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class TvShowsRepositoryDefaultTest {
    @MockK
    private lateinit var tvShowsRemoteSource: TvShowsRemoteSource

    lateinit var repository: TvShowsRepository

    @Before
    fun init() {
        MockKAnnotations.init(this)

        repository = TvShowsRepositoryDefault(
            tvShowsRemoteSource = tvShowsRemoteSource,
            coroutineDispatcher = Dispatchers.IO
        )
    }

    @Test
    fun getShowsSchedule_CallsCorrectSourceMethods() = runTest {
        coEvery { tvShowsRemoteSource.getShowsSchedule(any(), any()) } returns flowOf(mockk())

        repository.getShowsSchedule("US", "2024-05-31").first()

        coVerify {
            tvShowsRemoteSource.getShowsSchedule("US", "2024-05-31")
        }
    }

    @Test
    fun getShowDetail_CallsCorrectSourceMethods() = runTest {
        coEvery { tvShowsRemoteSource.getShowDetail(any()) } returns flowOf(mockk())

        repository.getShowDetail(1).first()

        coVerify {
            tvShowsRemoteSource.getShowDetail(1)
        }
    }

    @Test
    fun search_CallsCorrectSourceMethods() = runTest {
        coEvery { tvShowsRemoteSource.search(any()) } returns flowOf(mockk())

        repository.search("night").first()

        coVerify {
            tvShowsRemoteSource.search("night")
        }
    }
}