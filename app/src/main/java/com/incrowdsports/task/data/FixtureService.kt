package com.incrowdsports.task.data

import com.incrowdsports.task.data.models.Fixture
import com.incrowdsports.task.data.models.Match
import com.incrowdsports.task.data.models.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FixtureService {

    @GET("matches")
    suspend fun getFixtureList(
        @Query("compId") compId: Int,
        @Query("season") season: Int,
        @Query("size") size: Int,
    ): NetworkResponse<List<Fixture>>

    @GET("matches/{id}")
    suspend fun getPlayerList(
        @Path("id") matchId: String
    ): NetworkResponse<List<Match>>

}