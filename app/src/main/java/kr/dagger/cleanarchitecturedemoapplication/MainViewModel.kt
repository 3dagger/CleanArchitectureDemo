package kr.dagger.cleanarchitecturedemoapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kr.dagger.domain.usecase.GetMoviesPopularUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
	private val getMoviesPopularUseCase: GetMoviesPopularUseCase
) : ViewModel() {


	fun getMoviesPopular() {
		viewModelScope.launch(Dispatchers.IO) {
			getMoviesPopularUseCase.invoke().collect { result ->
				Log.d("leeam", "$result")
			}
		}
	}
}