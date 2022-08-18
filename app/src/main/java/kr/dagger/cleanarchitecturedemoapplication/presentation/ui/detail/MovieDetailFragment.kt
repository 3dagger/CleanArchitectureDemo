package kr.dagger.cleanarchitecturedemoapplication.presentation.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.navArgs
import kr.dagger.cleanarchitecturedemoapplication.R
import kr.dagger.cleanarchitecturedemoapplication.databinding.FragmentMovieDetailBinding
import kr.dagger.cleanarchitecturedemoapplication.presentation.base.BaseFragment

@AndroidEntryPoint
class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding>(R.layout.fragment_movie_detail) {

	private val navArgs: MovieDetailFragmentArgs by navArgs()
	private val viewModel: MovieDetailViewModel by viewModels()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding.apply {
			lifecycleOwner = viewLifecycleOwner
			vm = viewModel
		}

		viewModel.getMovieDetail(navArgs.movieId)
	}
}