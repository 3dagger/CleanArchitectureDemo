package kr.dagger.cleanarchitecturedemoapplication.presentation.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {

	@JvmStatic
	@BindingAdapter("bindMovieImage")
	fun ImageView.bindMovieImage(url: String?) {
		Glide
			.with(this)
			.load("https://image.tmdb.org/t/p/w500$url")
			.fitCenter()
			.into(this)
	}
}