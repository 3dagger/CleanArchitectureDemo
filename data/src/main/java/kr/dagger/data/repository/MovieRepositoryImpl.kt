package kr.dagger.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
import kr.dagger.data.entity.MoviePopularEntity
import kr.dagger.data.mapper.MoviePopularDtoMapper
import kr.dagger.data.remote.MovieApiService
import kr.dagger.data.remote.MovieStorage
import kr.dagger.domain.model.MoviePopular
import kr.dagger.domain.model.Response
import kr.dagger.domain.repository.MovieRepository

class MovieRepositoryImpl(private val storage: MovieStorage) : MovieRepository {

	override suspend fun getMoviesPopular(): Flow<Response<MoviePopular>> {
		return storage.getMoviesPopular().transform { response ->
			when (response) {
				is Response.Loading -> emit(Response.Loading())
				is Response.Fail -> emit(Response.Fail(e = response.e))
				is Response.Success -> emit(
					Response.Success(
						data = MoviePopularDtoMapper().convert(fromObject = response.data)
					)
				)
			}
		}
	}
}