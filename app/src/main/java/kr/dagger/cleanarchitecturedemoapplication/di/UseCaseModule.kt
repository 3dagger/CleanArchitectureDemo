package kr.dagger.cleanarchitecturedemoapplication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.dagger.domain.repository.MovieRepository
import kr.dagger.domain.usecase.GetMoviesPopularUseCase

@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {

	@Provides
	fun provideGetMoviesPopularUseCase(repository: MovieRepository): GetMoviesPopularUseCase {
		return GetMoviesPopularUseCase(movieRepository = repository)
	}
}