package kr.dagger.data.remote

import kr.dagger.data.entity.MoviePopularDetailsEntity
import kr.dagger.data.entity.MoviePopularEntity
import kr.dagger.domain.model.MoviePopularDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

	@GET("3/movie/popular")
	fun getPopularMovies(
		@Query("api_key") key: String,
		@Query("region") region: String,
		@Query("language") language: String,
		@Query("page") page: Int
	) : Call<MoviePopularEntity>

	@GET("3/movie/{id}")
	fun getMovieDetail(
		@Path("id") id: Int,
		@Query("api_key") key: String,
		@Query("region") region: String,
		@Query("language") language: String,
	) : Call<MoviePopularDetailsEntity>
}