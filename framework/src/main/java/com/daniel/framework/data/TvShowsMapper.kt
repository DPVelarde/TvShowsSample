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
import javax.inject.Inject

internal class TvShowsMapper @Inject constructor() {
    fun showsScheduleResponseToModel(showsSchedule: List<ShowScheduleResponse>): List<ShowSchedule> {
        return showsSchedule.map {
            ShowSchedule(
                id = it.id,
                name = it.name,
                airDate = it.airdate,
                airStamp = it.airstamp.orEmpty(),
                airTime = it.airtime,
                number = it.number,
                runtime = it.runtime,
                season = it.season,
                show = showScheduleResponseToModel(it.show),
                summary = it.summary,
                type = it.type.orEmpty()
            )
        }
    }

    fun showScheduleResponseToModel(show: ShowResponse): Show {
        return Show(
            id = show.id,
            name = show.name,
            image = showImageResponseToModel(show.image)
        )
    }

    fun showDetailResponseToModel(show: ShowResponse): Show {
        return Show(
            id = show.id,
            name = show.name,
            image = showImageResponseToModel(show.image),
            averageRuntime = show.averageRuntime,
            ended = show.ended,
            genres = show.genres,
            language = show.language,
            links = showLinksResponseToModel(show.links),
            network = showNetworkResponseToModel(show.network),
            officialSite = show.officialSite,
            premiered = show.premiered,
            runtime = show.runtime,
            schedule = showTimesResponseToModel(show.schedule),
            status = show.status,
            summary = show.summary,
            type = show.type,
            updated = show.updated
        )
    }

    private fun showImageResponseToModel(image: ImageResponse?): Image {
        return Image(
            medium = image?.medium.orEmpty(),
            original = image?.original.orEmpty()
        )
    }

    private fun showLinksResponseToModel(links: LinksResponse?): Links {
        return Links(
            showEpisodeResponseToModel(links?.nextEpisode),
            showEpisodeResponseToModel(links?.previousEpisode)
        )
    }

    private fun showEpisodeResponseToModel(episode: EpisodeResponse?): Episode {
        return Episode(
            href = episode?.href.orEmpty(),
            name = episode?.name.orEmpty()
        )
    }

    private fun showNetworkResponseToModel(network: NetworkResponse?): Network {
        return Network(
            networkCountryResponseToModel(network?.country),
            network?.id ?: -1,
            network?.name.orEmpty(),
            network?.officialSite.orEmpty()
        )
    }

    private fun networkCountryResponseToModel(country: CountryResponse?): Country {
        return Country(
            country?.code.orEmpty(),
            country?.name.orEmpty(),
            country?.timezone.orEmpty()
        )
    }

    private fun showTimesResponseToModel(schedule: ScheduleResponse?): Schedule {
        return Schedule(
            schedule?.days ?: emptyList(),
            schedule?.time.orEmpty()
        )
    }

}
