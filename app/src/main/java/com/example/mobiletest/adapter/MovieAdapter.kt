package com.example.mobiletest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiletest.databinding.ListviewRecycleviewBinding
import com.example.mobiletest.data.remote.MovieApi
import com.example.mobiletest.utis.loadImage

class MovieAdapter(
    private val onMovieClik : (MovieApi) -> Unit
) : ListAdapter<MovieApi, MovieAdapter.MyViewHolder>(DiffCallback()) {

    class MyViewHolder(private val binding: ListviewRecycleviewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieApi) {
            loadImage(binding.imageView, item.poster_path)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListviewRecycleviewBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currenItem = getItem(position)
        holder.itemView.setOnClickListener {
            onMovieClik(currenItem)
        }
        holder.bind(currenItem)
    }

    class DiffCallback : DiffUtil.ItemCallback<MovieApi>() {
        override fun areItemsTheSame(oldItem: MovieApi, newItem: MovieApi): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: MovieApi, newItem: MovieApi): Boolean = oldItem == newItem
    }
}

