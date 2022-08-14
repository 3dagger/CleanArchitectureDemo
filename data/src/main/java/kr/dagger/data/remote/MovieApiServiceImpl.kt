package kr.dagger.data.remote

import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kr.dagger.data.entity.MoviePopularEntity
import kr.dagger.domain.model.Response
import retrofit2.Call
import retrofit2.Callback
import retrofit2.awaitResponse

class MovieApiServiceImpl(private val movieApiService: MovieApiService) : MovieStorage {

	override suspend fun getMoviesPopular(): Flow<Response<MoviePopularEntity>> {
		return callbackFlow {
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

}