package com.astridnig.moviesapp.presentation.movies.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.astridnig.moviesapp.databinding.MoviesItemBinding
import com.astridnig.moviesapp.presentation.movies.adapter.viewholder.ItemMoviesViewHolder
import com.astridnig.moviesapp.presentation.movies.model.Movie

class MoviesAdapter(
    private val context: Context,
    private val movies: List<Movie>,
    private val onItemClick: (Movie) -> Unit
) : RecyclerView.Adapter<ItemMoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemMoviesViewHolder {
        val binding = MoviesItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ItemMoviesViewHolder(context, binding)
    }

    override fun getItemCount(): Int {
        return movies.size

    }

    override fun onBindViewHolder(holder: ItemMoviesViewHolder, position: Int) {
        val movieItem: Movie = movies[position]

        holder.bind(movieItem)
        {
            onItemClick.invoke(movieItem)
        }
    }
}
