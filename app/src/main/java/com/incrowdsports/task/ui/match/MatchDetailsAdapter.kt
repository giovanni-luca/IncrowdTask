package com.incrowdsports.task.ui.match

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.incrowdsports.task.data.models.Player
import com.incrowdsports.task.databinding.PlayerLayoutBinding

class MatchDetailsAdapter : ListAdapter<MatchDetailsAdapter.PlayerItem, RecyclerView.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MatchViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MatchViewHolder).bind(getItem(position))
    }

    private class MatchViewHolder(private val binding: PlayerLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PlayerItem) {
            binding.name.text = item.player.firstName
            binding.lastName.text = item.player.lastName
        }

        companion object {
            fun create(parent: ViewGroup) = MatchViewHolder(PlayerLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }

    }

    data class PlayerItem(
        val player: Player
    )

    private companion object {
        val diffCallback = object : DiffUtil.ItemCallback<PlayerItem>() {
            override fun areItemsTheSame(oldItem: PlayerItem, newItem: PlayerItem): Boolean {
                return oldItem.player.id == newItem.player.id
            }

            override fun areContentsTheSame(oldItem: PlayerItem, newItem: PlayerItem): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    }

}