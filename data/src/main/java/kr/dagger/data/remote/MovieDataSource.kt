package kr.dagger.data.remote

import kotlinx.coroutines.flow.Flow
import kr.dagger.data.entity.MoviePopularDetailsEntity
import kr.dagger.data.entity.MoviePopularEntity
import kr.dagger.domain.model.Response

interface MovieDataSource {

	suspend fun getMoviesPopular(): Flow<Response<MoviePopularEntity>>

	suspend fun getMovieDetail(id: Int): Flow<Response<MoviePopularDetailsEntity>>
}