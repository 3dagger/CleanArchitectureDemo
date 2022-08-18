package kr.dagger.data.remote

import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kr.dagger.data.entity.MoviePopularDetailsEntity
import kr.dagger.data.entity.MoviePopularEntity
import kr.dagger.domain.model.Response
import retrofit2.Call
import retrofit2.Callback

class MovieDataSourceImpl(private val movieApiService: MovieApiService) : MovieDataSource {

	override suspend fun getMoviesPopular(): Flow<Response<MoviePopularEntity>> {
		return callbackFlow {
			trySend(Response.Loading())

			movieApiService.getPopularMovies(
				key = "08815fd668b24845db10f877f037cae9",
				region = "kr",
				page = 1,
				language = "ko"
			).enqueue(object : Callback<MoviePopularEntity> {
				override fun onResponse(
					call: Call<MoviePopularEntity>,
					response: retrofit2.Response<MoviePopularEntity>
				) {
					response.body().let {
						if (it != null) trySend(Response.Success(data = it))
					}
				}
				override fun onFailure(call: Call<MoviePopularEntity>, t: Throwable) {
					trySend(Response.Fail(e = t as Exception))
				}
			})

			awaitClose { this.cancel() }
		}
	}

	override suspend fun getMovieDetail(id: Int): Flow<Response<MoviePopularDetailsEntity>> {
		return callbackFlow {
			trySend(Response.Loading())

			movieApiService.getMovieDetail(
				id = id,
				key = "08815fd668b24845db10f877f037cae9",
				region = "kr",
				language = "ko"
			).enqueue(object : Callback<MoviePopularDetailsEntity> {
				override fun onResponse(
					call: Call<MoviePopularDetailsEntity>,
					response: retrofit2.Response<MoviePopularDetailsEntity>
				) {
					response.body().let {
						if (it != null) trySend(Response.Success(data = it))
					}
				}

				override fun onFailure(call: Call<MoviePopularDetailsEntity>, t: Throwable) {
					trySend(Response.Fail(e = t as Exception))
				}
			})

			awaitClose { this.cancel() }
		}
	}
}