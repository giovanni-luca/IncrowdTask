package com.incrowdsports.task.ui.match

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.incrowdsports.task.data.MatchRepository
import com.incrowdsports.task.data.models.Player
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchDetailsViewModel @Inject constructor(private val matchRepository: MatchRepository) : ViewModel() {

    val playerList = MutableStateFlow<List<Player>>(emptyList())

    fun loadData(matchId: Int = 2210271) {
        viewModelScope.launch(Dispatchers.IO) {
            val players = mutableListOf<Player>()
            val data = matchRepository.getPlayerList(matchId = matchId)
            data.forEach {
                players.addAll(it.homeTeam.players)
                players.addAll(it.awayTeam.players)
            }
            playerList.value = players
        }
    }
}