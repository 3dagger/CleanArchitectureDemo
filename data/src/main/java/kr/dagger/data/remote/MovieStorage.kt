package kr.dagger.data.remote

import kotlinx.coroutines.flow.Flow
import kr.dagger.data.entity.MoviePopularEntity
import kr.dagger.domain.model.Response

interface MovieStorage {

	suspend fun getMoviesPopular(): Flow<Response<MoviePopularEntity>>
}