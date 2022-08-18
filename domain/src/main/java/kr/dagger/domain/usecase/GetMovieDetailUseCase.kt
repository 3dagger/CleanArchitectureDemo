package kr.dagger.domain.usecase

import kotlinx.coroutines.flow.Flow
import kr.dagger.domain.model.MoviePopular
import kr.dagger.domain.model.MoviePopularDetails
import kr.dagger.domain.model.Response
import kr.dagger.domain.repository.MovieRepository

class GetMovieDetailUseCase(private val movieRepository: MovieRepository) {

	suspend operator fun invoke(id: Int): Flow<Response<MoviePopularDetails>> {
		return movieRepository.getMovieDetail(id = id)
	}
}