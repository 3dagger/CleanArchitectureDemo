package kr.dagger.cleanarchitecturedemoapplication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.dagger.data.remote.MovieApiService
import kr.dagger.data.remote.MovieApiServiceImpl
import kr.dagger.data.remote.MovieStorage
import kr.dagger.data.repository.MovieRepositoryImpl
import kr.dagger.domain.repository.MovieRepository
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

	@Provides
	@Singleton
	fun provideMovieStorage(movieApiService: MovieApiService): MovieStorage {
		return MovieApiServiceImpl(movieApiService)
	}
	
	@Provides
	@Singleton
	fun provideMovieRepository(movieStorage: MovieStorage): MovieRepository {
		return MovieRepositoryImpl(movieStorage)
	}
}