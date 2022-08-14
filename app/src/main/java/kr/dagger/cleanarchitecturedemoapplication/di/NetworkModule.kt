package kr.dagger.cleanarchitecturedemoapplication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.dagger.data.remote.MovieApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

	@Provides
	@Singleton
	fun provideOkhttpClient(): OkHttpClient {
		return OkHttpClient.Builder()
			.connectTimeout(15, TimeUnit.SECONDS)
			.readTimeout(15, TimeUnit.SECONDS)
			.build()
	}

	@Provides
	@Singleton
	fun provideRetrofit() : MovieApiService {
		return Retrofit.Builder()
			.baseUrl("https://api.themoviedb.org/")
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create(MovieApiService::class.java)
	}
}