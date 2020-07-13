package com.example.hiltpractice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltpractice.models.Movie
import com.example.hiltpractice.R

/**
 * Created by hilma on 09/07/2020.
 */
class MovieAdapter(private val items: List<Movie>): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private var movieTitle: TextView = view.findViewById(R.id.movie_title)

        fun bindItem(item: Movie) {
            movieTitle.text = item.original_title
        }
    }
}