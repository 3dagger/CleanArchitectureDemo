package kr.dagger.cleanarchitecturedemoapplication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.dagger.data.remote.MovieApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
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
			.addInterceptor (
				HttpLoggingInterceptor().apply {
					this.level = HttpLoggingInterceptor.Level.BODY
				}
			)
			.build()
	}

	@Provides
	@Singleton
	fun provideRetrofit(
		okHttpClient: OkHttpClient,
		gsonConverterFactory: GsonConverterFactory
	) : Retrofit {
		return Retrofit.Builder()
			.baseUrl("https://api.themoviedb.org/")
			.client(okHttpClient)
			.addConverterFactory(gsonConverterFactory)
			.build()
	}

	@Provides
	@Singleton
	fun provideGsonConverterFactory() : GsonConverterFactory {
		return GsonConverterFactory.create()
	}

	@Provides
	@Singleton
	fun provideMovieApiService(retrofit: Retrofit) : MovieApiService {
		return retrofit.create(MovieApiService::class.java)
	}
}