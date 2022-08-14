package kr.dagger.domain.repository

import kotlinx.coroutines.flow.Flow
import kr.dagger.domain.model.MoviePopular
import kr.dagger.domain.model.Response

interface MovieRepository {

	suspend fun getMoviesPopular(): Flow<Response<MoviePopular>>
}