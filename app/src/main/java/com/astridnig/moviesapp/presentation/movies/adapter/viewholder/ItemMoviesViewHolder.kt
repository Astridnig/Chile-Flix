package com.astridnig.moviesapp.presentation.movies.adapter.viewholder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.astridnig.moviesapp.databinding.MoviesItemBinding
import com.astridnig.moviesapp.presentation.movies.model.Movie


class ItemMoviesViewHolder(
    val context: Context,
    val binding: MoviesItemBinding,
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(movie: Movie, onItemClick: () -> Unit) {

        binding.apply {
            title.text = movie.title
            overview.text = movie.overview
            cardMovie.setOnClickListener {
                onItemClick.invoke()
            }


        }
    }
}

