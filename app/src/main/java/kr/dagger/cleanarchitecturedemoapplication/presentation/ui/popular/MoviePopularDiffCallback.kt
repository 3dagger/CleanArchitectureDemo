package kr.dagger.cleanarchitecturedemoapplication.presentation.ui.popular

import androidx.recyclerview.widget.DiffUtil
import kr.dagger.domain.model.MoviePopularDetails

class MoviePopularDiffCallback : DiffUtil.ItemCallback<MoviePopularDetails>() {

	override fun areItemsTheSame(oldItem: MoviePopularDetails, newItem: MoviePopularDetails): Boolean {
		return oldItem.id == newItem.id && oldItem.backdrop_path == newItem.backdrop_path
	}

	override fun areContentsTheSame(oldItem: MoviePopularDetails, newItem: MoviePopularDetails): Boolean {
		return oldItem == newItem
	}
}