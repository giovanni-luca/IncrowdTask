package com.incrowdsports.task.data

import com.incrowdsports.task.data.models.Fixture
import com.incrowdsports.task.data.models.Match
import javax.inject.Inject

class MatchRepository @Inject constructor(
    private val fixtureService: FixtureService
) {
    suspend fun getFixtureList(compId: Int, season: Int, size: Int): List<Fixture> =
        fixtureService.getFixtureList(compId = compId, season = season, size = size).data

    suspend fun getPlayerList(matchId: Int): List<Match> =
        fixtureService.getPlayerList(matchId.toString()).data
}