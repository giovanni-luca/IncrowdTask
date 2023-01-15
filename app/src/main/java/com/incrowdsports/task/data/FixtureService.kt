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

    //TODO it is not working, there are an error with the model I couldn't fix in time :(
    @GET("matches/{id}")
    suspend fun getPlayerList(
        @Path("id") matchId: String
    ): NetworkResponse<List<Match>>

}