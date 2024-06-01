package com.daniel.framework.data

import com.daniel.framework.data.dto.ShowResponse
import com.daniel.framework.data.dto.ShowScheduleResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface TvShowsApi {

    @GET("schedule")
    suspend fun getShowsSchedule(
        @Query("country") country: String? = null,
        @Query("date") date: String? = null
    ): List<ShowScheduleResponse>

    @GET("shows/{id}")
    suspend fun getShowDetail(
        @Path("id") id: Int
    ): ShowResponse

}