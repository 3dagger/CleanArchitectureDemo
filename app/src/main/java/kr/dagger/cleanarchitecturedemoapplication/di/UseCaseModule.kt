package kr.dagger.cleanarchitecturedemoapplication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.dagger.domain.repository.MovieRepository
import kr.dagger.domain.usecase.GetMovieDetailUseCase
import kr.dagger.domain.usecase.GetMoviePopularUseCase

@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {

	@Provides
	fun provideGetMoviesPopularUseCase(repository: MovieRepository): GetMoviePopularUseCase {
		return GetMoviePopularUseCase(movieRepository = repository)
	}

	@Provides
	fun provideGetMovieDetailUseCase(repository: MovieRepository) : GetMovieDetailUseCase {
		return GetMovieDetailUseCase(movieRepository = repository)
	}
}