package com.example.mobiletest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiletest.R
import com.example.mobiletest.data.Movie
import kotlinx.android.synthetic.main.listview_recycleview.view.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    private var movieList = emptyList<Movie>()

    class MyViewHolder(item: View): RecyclerView.ViewHolder(item) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.listview_recycleview, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currenItem = movieList[position]
        holder.itemView.txttitle.text = currenItem.Title
        holder.itemView.txtrelase.text = currenItem.Releaser_year
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun setData(movie: List<Movie>) {
        this.movieList = movie
        notifyDataSetChanged()
    }

}