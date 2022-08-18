package kr.dagger.cleanarchitecturedemoapplication.presentation.ui.popular


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.dagger.cleanarchitecturedemoapplication.databinding.ItemPopularMovieBinding
import kr.dagger.domain.model.MoviePopularDetails

class PopularMovieAdapter : ListAdapter<MoviePopularDetails, PopularMovieAdapter.PopularMovieViewHolder>(MoviePopularDiffCallback()){

	private var listener : PopularMovieClickListener? = null

	fun setOnClickListener(listener: PopularMovieClickListener) {
		this.listener = listener
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {
		return PopularMovieViewHolder(ItemPopularMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
	}

	override fun onBindViewHolder(holder: PopularMovieViewHolder, position: Int) {
		holder.bind(currentList[position])
	}

	inner class PopularMovieViewHolder(private val binding: ItemPopularMovieBinding) : RecyclerView.ViewHolder(binding.root) {
		fun bind(item: MoviePopularDetails) {
			binding.apply {
				data = item
				cardView.setOnClickListener {
					listener?.onItemClicked(id = currentList[adapterPosition].id)
				}
			}
		}
	}
}