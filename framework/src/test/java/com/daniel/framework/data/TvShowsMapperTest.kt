package com.daniel.framework.data

import com.daniel.data.model.Country
import com.daniel.data.model.Episode
import com.daniel.data.model.Image
import com.daniel.data.model.Links
import com.daniel.data.model.Network
import com.daniel.data.model.Schedule
import com.daniel.data.model.Show
import com.daniel.data.model.ShowSchedule
import com.daniel.framework.data.dto.CountryResponse
import com.daniel.framework.data.dto.EpisodeResponse
import com.daniel.framework.data.dto.ImageResponse
import com.daniel.framework.data.dto.LinksResponse
import com.daniel.framework.data.dto.NetworkResponse
import com.daniel.framework.data.dto.ScheduleResponse
import com.daniel.framework.data.dto.ShowResponse
import com.daniel.framework.data.dto.ShowScheduleResponse
import com.daniel.framework.data.dto.ShowSearchResponse
import io.mockk.MockKAnnotations
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TvShowsMapperTest {
    private lateinit var tvShowsMapper: TvShowsMapper

    @Before
    fun init() {
        MockKAnnotations.init(this)

        tvShowsMapper = TvShowsMapper()
    }

    @Test
    fun showsScheduleResponseToModel_ThenReturnCorrectMappedInstance() {
        val expectedList = listOf(showScheduleResponse)

        val result = tvShowsMapper.showsScheduleResponseToModel(expectedList)

        assertEquals(
            listOf(
                ShowSchedule(
                    id = SHOW_SCHEDULE_ID,
                    name = SHOW_SCHEDULE_NAME,
                    airTime = AIR_TIME,
                    airDate = AIR_DATE,
                    airStamp = AIR_STAMP,
                    number = NUMBER,
                    runtime = RUNTIME,
                    season = SEASON,
                    show = Show(
                        id = SHOW_ID,
                        name = SHOW_NAME,
                        image = Image(
                            medium = SHOW_IMAGE_MEDIUM,
                            original = SHOW_IMAGE_ORIGINAL
                        )
                    ),
                    summary = SUMMARY,
                    type = TYPE
                )
            ), result
        )
    }

    @Test
    fun showDetailResponseToModel_ThenReturnCorrectMappedInstance() {
        val expected = showResponse

        val result = tvShowsMapper.showDetailResponseToModel(expected)

        assertEquals(
            Show(
                id = SHOW_ID,
                name = SHOW_NAME,
                image = Image(
                    medium = SHOW_IMAGE_MEDIUM,
                    original = SHOW_IMAGE_ORIGINAL
                ),
                averageRuntime = SHOW_AVERAGE_RUNTIME,
                ended = SHOW_ENDED,
                genres = "Drama|Comedy",
                language = SHOW_LANGUAGE,
                links = Links(
                    previousEpisode = Episode(
                        href = SHOW_PREVIOUS_EPISODE_HREF,
                        name = SHOW_PREVIOUS_EPISODE_NAME
                    ),
                    nextEpisode = Episode(
                        href = SHOW_NEXT_EPISODE_HREF,
                        name = SHOW_NEXT_EPISODE_NAME
                    )
                ),
                Network(
                    country = Country(
                        code = SHOW_NETWORK_COUNTRY_CODE,
                        name = SHOW_NETWORK_COUNTRY_NAME,
                        timeZone = SHOW_NETWORK_COUNTRY_TIMEZONE
                    ),
                    id = SHOW_NETWORK_ID,
                    name = SHOW_NETWORK_NAME,
                    officialSite = SHOW_NETWORK_OFFICIAL_SITE
                ),
                officialSite = SHOW_OFFICIAL_SITE,
                premiered = SHOW_PREMIERED,
                runtime = SHOW_RUNTIME,
                Schedule(
                    days = SHOW_SCHEDULE_DAYS,
                    time = SHOW_SCHEDULE_TIME
                ),
                status = SHOW_STATUS,
                summary = SHOW_SUMMARY,
                type = SHOW_TYPE,
                updated = SHOW_UPDATED
            ),
            result
        )
    }

    @Test
    fun showsSearchResponseToModel_ThenReturnCorrectMappedInstance() {
        val expectedList = listOf(
            ShowSearchResponse(
                0.9,
                showResponse
            )
        )

        val result = tvShowsMapper.showsSearchResponseToModel(expectedList)

        assertEquals(
            listOf(
                Show(
                    id = SHOW_ID,
                    name = SHOW_NAME,
                    image = Image(
                        medium = SHOW_IMAGE_MEDIUM,
                        original = SHOW_IMAGE_ORIGINAL
                    ),
                    averageRuntime = SHOW_AVERAGE_RUNTIME,
                    ended = SHOW_ENDED,
                    genres = "Drama|Comedy",
                    language = SHOW_LANGUAGE,
                    links = Links(
                        previousEpisode = Episode(
                            href = SHOW_PREVIOUS_EPISODE_HREF,
                            name = SHOW_PREVIOUS_EPISODE_NAME
                        ),
                        nextEpisode = Episode(
                            href = SHOW_NEXT_EPISODE_HREF,
                            name = SHOW_NEXT_EPISODE_NAME
                        )
                    ),
                    Network(
                        country = Country(
                            code = SHOW_NETWORK_COUNTRY_CODE,
                            name = SHOW_NETWORK_COUNTRY_NAME,
                            timeZone = SHOW_NETWORK_COUNTRY_TIMEZONE
                        ),
                        id = SHOW_NETWORK_ID,
                        name = SHOW_NETWORK_NAME,
                        officialSite = SHOW_NETWORK_OFFICIAL_SITE
                    ),
                    officialSite = SHOW_OFFICIAL_SITE,
                    premiered = SHOW_PREMIERED,
                    runtime = SHOW_RUNTIME,
                    Schedule(
                        days = SHOW_SCHEDULE_DAYS,
                        time = SHOW_SCHEDULE_TIME
                    ),
                    status = SHOW_STATUS,
                    summary = SHOW_SUMMARY,
                    type = SHOW_TYPE,
                    updated = SHOW_UPDATED
                )
            ),
            result
        )
    }

    companion object {
        private const val AIR_DATE = "2024-05-31"
        private const val AIR_STAMP = "2024-05-31T04:35:00+00:00"
        private const val AIR_TIME = "00:35"
        private const val SHOW_SCHEDULE_ID = 2844976
        private const val SHOW_SCHEDULE_NAME = "Episode 108"
        private const val NUMBER = 108
        private const val RUNTIME = 30
        private const val SEASON = 2024
        private const val SUMMARY = "This is a summary"
        private const val TYPE = "regular"
        private const val URL =
            "https://www.tvmaze.com/episodes/2844976/nightline-2024-05-30-episode-108"

        private const val SHOW_ID = 7500
        private const val SHOW_NAME = "Nightline"
        private const val SHOW_IMAGE_MEDIUM =
            "https://static.tvmaze.com/uploads/images/medium_portrait/357/892587.jpg"
        private const val SHOW_IMAGE_ORIGINAL =
            "https://static.tvmaze.com/uploads/images/original_untouched/357/892587.jpg"
        private const val SHOW_AVERAGE_RUNTIME = 30
        private const val SHOW_ENDED = "Yes"
        private val SHOW_GENRES = listOf("Drama", "Comedy")
        private const val SHOW_LANGUAGE = ""
        private const val SHOW_NEXT_EPISODE_HREF = "https://api.tvmaze.com/episodes/2844978"
        private const val SHOW_NEXT_EPISODE_NAME = "Episode 110"
        private const val SHOW_PREVIOUS_EPISODE_HREF = "https://api.tvmaze.com/episodes/2844977"
        private const val SHOW_PREVIOUS_EPISODE_NAME = "Episode 109"
        private const val SHOW_NETWORK_ID = 3
        private const val SHOW_NETWORK_NAME = "ABC"
        private const val SHOW_NETWORK_COUNTRY_NAME = "United States"
        private const val SHOW_NETWORK_COUNTRY_CODE = "US"
        private const val SHOW_NETWORK_COUNTRY_TIMEZONE = "America/New_York"
        private const val SHOW_NETWORK_OFFICIAL_SITE = "https://abc.com/"
        private const val SHOW_OFFICIAL_SITE = "http://abcnews.go.com/Nightline"
        private const val SHOW_PREMIERED = "1980-03-24"
        private const val SHOW_RUNTIME = 30
        private const val SHOW_SCHEDULE_TIME = "00:35"
        private val SHOW_SCHEDULE_DAYS = listOf(
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday"
        )
        private const val SHOW_STATUS = "Running"
        private const val SHOW_SUMMARY =
            "\u003Cp\u003E\u003Cb\u003ENightline\u003C/b\u003E is a half-hour program provides viewers with in-depth reporting on one or more of the major stories in the news, with occasional segments on pop culture. Journalists Dan Harris, Juju Chang and Byron Pitts share hosting duties for this late-night program.\u003C/p\u003E"
        private const val SHOW_TYPE = "News"
        private const val SHOW_UPDATED = 1714478075
        private const val SHOW = ""
        private const val SHOW_URL = "https://www.tvmaze.com/shows/7500/nightline"
        private const val SHOW_WEIGHT = 92

        private val showResponse = ShowResponse(
            id = SHOW_ID,
            name = SHOW_NAME,
            averageRuntime = SHOW_AVERAGE_RUNTIME,
            ended = SHOW_ENDED,
            genres = SHOW_GENRES,
            image = ImageResponse(
                SHOW_IMAGE_MEDIUM,
                SHOW_IMAGE_ORIGINAL
            ),
            language = SHOW_LANGUAGE,
            links = LinksResponse(
                nextEpisode = EpisodeResponse(
                    href = SHOW_NEXT_EPISODE_HREF,
                    name = SHOW_NEXT_EPISODE_NAME
                ),
                previousEpisode = EpisodeResponse(
                    href = SHOW_PREVIOUS_EPISODE_HREF,
                    name = SHOW_PREVIOUS_EPISODE_NAME
                )
            ),
            network = NetworkResponse(
                id = SHOW_NETWORK_ID,
                name = SHOW_NETWORK_NAME,
                country = CountryResponse(
                    code = SHOW_NETWORK_COUNTRY_CODE,
                    name = SHOW_NETWORK_COUNTRY_NAME,
                    timezone = SHOW_NETWORK_COUNTRY_TIMEZONE
                ),
                officialSite = SHOW_NETWORK_OFFICIAL_SITE
            ),
            officialSite = SHOW_OFFICIAL_SITE,
            premiered = SHOW_PREMIERED,
            runtime = SHOW_RUNTIME,
            schedule = ScheduleResponse(
                time = SHOW_SCHEDULE_TIME,
                days = SHOW_SCHEDULE_DAYS
            ),
            status = SHOW_STATUS,
            summary = SHOW_SUMMARY,
            type = SHOW_TYPE,
            updated = SHOW_UPDATED,
            url = SHOW_URL,
            weight = SHOW_WEIGHT
        )

        private val showScheduleResponse = ShowScheduleResponse(
            airdate = AIR_DATE,
            airstamp = AIR_STAMP,
            airtime = AIR_TIME,
            id = SHOW_SCHEDULE_ID,
            name = SHOW_SCHEDULE_NAME,
            number = NUMBER,
            runtime = RUNTIME,
            season = SEASON,
            show = showResponse,
            summary = SUMMARY,
            type = TYPE
        )
    }

}