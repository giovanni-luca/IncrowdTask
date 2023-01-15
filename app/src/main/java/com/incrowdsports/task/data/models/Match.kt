package com.incrowdsports.task.data.models


data class Match(
    val id: String,
    val competition: String,
    val period: String,
    val date: String,
    val homeTeam: TeamStats,
    val awayTeam: TeamStats,
    val venue: Venue
)

data class TeamStats(
    val id: String,
    val name: String,
    val score: String,
    val players: List<Player>
)

data class Player(
    val id: String,
    val firstName: String,
    val lastName: String,
    val status: String,
    val imageUrl: String
)