package com.incrowdsports.task.ui.match

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.incrowdsports.task.R
import com.incrowdsports.task.data.models.Player
import com.incrowdsports.task.databinding.PlayersListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MatchDetailsFragment : Fragment(R.layout.players_list_fragment) {

    private val binding by lazy { PlayersListFragmentBinding.bind(requireView()) }
    private val viewModel: MatchDetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MatchDetailsAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.loadData()

        viewModel.playerList
            .flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { renderPlayerList(playerList = it, adapter = adapter) }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun renderPlayerList(playerList: List<Player>, adapter: MatchDetailsAdapter) {
        val itemList = playerList.map {
            MatchDetailsAdapter.PlayerItem(
                player = it
            )
        }
        adapter.submitList(itemList)
    }

    companion object {
        fun newInstance() = MatchDetailsFragment()
    }

}