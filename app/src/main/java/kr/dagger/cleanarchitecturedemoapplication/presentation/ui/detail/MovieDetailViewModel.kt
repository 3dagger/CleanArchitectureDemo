package kr.dagger.cleanarchitecturedemoapplication.presentation.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.dagger.domain.model.MoviePopularDetails
import kr.dagger.domain.model.Response
import kr.dagger.domain.usecase.GetMovieDetailUseCase
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
	private val getMovieDetailUseCase: GetMovieDetailUseCase
) : ViewModel() {

	private val _isLoading = MutableLiveData<Boolean>()
	val isLoading: LiveData<Boolean>
		get() = _isLoading

	private val _movieDetailData = MutableLiveData<MoviePopularDetails?>()
	val movieDetailData : LiveData<MoviePopularDetails?>
		get() = _movieDetailData

	fun getMovieDetail(id: Int) {
		viewModelScope.launch(Dispatchers.IO) {
			getMovieDetailUseCase.invoke(id).collect { result ->
				when (result) {
					is Response.Loading -> {
						_isLoading.postValue(true)
					}
					is Response.Success -> {
						_isLoading.postValue(false)
						_movieDetailData.postValue(result.data)
					}
					is Response.Fail -> {
						_isLoading.postValue(false)
					}
				}
			}
		}
	}
}