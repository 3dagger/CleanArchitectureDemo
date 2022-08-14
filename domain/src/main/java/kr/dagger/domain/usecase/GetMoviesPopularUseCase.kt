package kr.dagger.domain.usecase

import kotlinx.coroutines.flow.Flow
import kr.dagger.domain.model.MoviePopular
import kr.dagger.domain.model.Response
import kr.dagger.domain.repository.MovieRepository

class GetMoviesPopularUseCase(private val movieRepository: MovieRepository) {

	suspend operator fun invoke(): Flow<Response<MoviePopular>> {
		return movieRepository.getMoviesPopular()
	}
}