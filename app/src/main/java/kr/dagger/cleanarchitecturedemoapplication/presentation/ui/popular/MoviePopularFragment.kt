package kr.dagger.cleanarchitecturedemoapplication.presentation.ui.popular

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kr.dagger.cleanarchitecturedemoapplication.R
import kr.dagger.cleanarchitecturedemoapplication.databinding.FragmentMoviePopularBinding
import kr.dagger.cleanarchitecturedemoapplication.presentation.base.BaseFragment

@AndroidEntryPoint
class MoviePopularFragment : BaseFragment<FragmentMoviePopularBinding>(R.layout.fragment_movie_popular),
	PopularMovieClickListener {

	private val viewModel: MoviePopularViewModel by viewModels()
	private val movieAdapter: PopularMovieAdapter by lazy { PopularMovieAdapter() }

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		viewModel.getMoviesPopular()

		initViewSetup()
		subscribeObservers()
	}

	private fun initViewSetup() {
		binding.recyclerView.apply {
			adapter = movieAdapter
			layoutManager = GridLayoutManager(requireActivity(), 2)
		}
		movieAdapter.setOnClickListener(this)
	}

	override fun onItemClicked(id: Int) {
		findNavController().navigate(MoviePopularFragmentDirections.actionMoviePopularFragmentToMovieDetailFragment(id))
	}

	private fun subscribeObservers() {
		viewLifecycleOwner.lifecycleScope.launch {
			viewModel.popularMovieData.observe(viewLifecycleOwner) {
				movieAdapter.submitList(it)
			}
		}
	}
}