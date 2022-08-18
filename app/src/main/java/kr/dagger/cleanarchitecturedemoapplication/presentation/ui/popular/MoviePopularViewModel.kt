package kr.dagger.cleanarchitecturedemoapplication.presentation.ui.popular

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kr.dagger.domain.model.MoviePopular
import kr.dagger.domain.model.MoviePopularDetails
import kr.dagger.domain.model.Response
import kr.dagger.domain.usecase.GetMoviePopularUseCase
import javax.inject.Inject

@HiltViewModel
class MoviePopularViewModel @Inject constructor(
	private val getMoviePopularUseCase: GetMoviePopularUseCase
) : ViewModel() {

	private val _popularMovieData = MutableLiveData<List<MoviePopularDetails>>()
	val popularMovieData: LiveData<List<MoviePopularDetails>>
		get() = _popularMovieData


	fun getMoviesPopular() {
		viewModelScope.launch(Dispatchers.IO) {
			getMoviePopularUseCase.invoke().collect { result ->
				when (result) {
					is Response.Loading -> {
					}
					is Response.Success -> {
						_popularMovieData.postValue(result.data.results)
					}
					is Response.Fail -> {

					}
				}
			}
		}
	}
}