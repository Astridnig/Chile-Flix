package com.astridnig.moviesapp.presentation.movies.adapter.viewholder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.astridnig.moviesapp.databinding.MoviesItemBinding
import com.astridnig.moviesapp.presentation.movies.model.Movie
import com.bumptech.glide.Glide


class ItemMoviesViewHolder(
    val context: Context,
    val binding: MoviesItemBinding,
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(movie: Movie, onItemClick: () -> Unit) {

        binding.apply {
            title.text = movie.title
            overview.text = movie.overview
            note.text = movie.voteAverage.toString() + "/10"
            releaseDate.text = movie.releaseDate
            Glide.with(context).load("https://image.tmdb.org/t/p/w440_and_h660_face/" + movie.posterPath).into(imagePoster)
            cardMovie.setOnClickListener {
                onItemClick.invoke()
            }


        }
    }
}

