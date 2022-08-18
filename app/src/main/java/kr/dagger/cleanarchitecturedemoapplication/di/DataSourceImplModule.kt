package kr.dagger.cleanarchitecturedemoapplication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.dagger.data.remote.MovieApiService
import kr.dagger.data.remote.MovieDataSource
import kr.dagger.data.remote.MovieDataSourceImpl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataSourceImplModule {

	@Provides
	@Singleton
	fun provideMovieDataSource(movieApiService: MovieApiService): MovieDataSource {
		return MovieDataSourceImpl(movieApiService)
	}
}