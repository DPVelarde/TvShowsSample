package com.daniel.framework.data

import com.daniel.data.TvShowsRemoteSource
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class TvShowsMazeSourceTest {
    @MockK
    private lateinit var tvSHowsApi: TvShowsApi

    @MockK
    private lateinit var tvShowsMapper: TvShowsMapper

    lateinit var source: TvShowsRemoteSource

    @Before
    fun init() {
        MockKAnnotations.init(this)

        source = TvShowsMazeSource(
            tvSHowsApi = tvSHowsApi,
            tvShowsMapper = tvShowsMapper
        )
    }

    @Test
    fun getShowsSchedule_CallsCorrectMapperMethodAndApi() = runTest {
        coEvery { tvSHowsApi.getShowsSchedule(any(), any()) } returns listOf()
        every { tvShowsMapper.showsScheduleResponseToModel(any()) } returns mockk()

        source.getShowsSchedule("US", "2024-05-31").first()

        coVerify {
            tvShowsMapper.showsScheduleResponseToModel(any())
            tvSHowsApi.getShowsSchedule("US", "2024-05-31")
        }
    }

    @Test
    fun getShowDetail_CallsCorrectMapperMethodAndApi() = runTest {
        coEvery { tvSHowsApi.getShowDetail(any()) } returns mockk()
        every { tvShowsMapper.showDetailResponseToModel(any()) } returns mockk()

        source.getShowDetail(1).first()

        coVerify {
            tvShowsMapper.showDetailResponseToModel(any())
            tvSHowsApi.getShowDetail(1)
        }
    }

    @Test
    fun search_CallsCorrectMapperMethodAndApi() = runTest {
        coEvery { tvSHowsApi.searchShow(any()) } returns listOf()
        every { tvShowsMapper.showsSearchResponseToModel(any()) } returns mockk()

        source.search("night").first()

        coVerify {
            tvShowsMapper.showsSearchResponseToModel(any())
            tvSHowsApi.searchShow("night")
        }
    }
}