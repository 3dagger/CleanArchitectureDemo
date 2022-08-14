package kr.dagger.data.mapper

import kr.dagger.data.entity.MoviePopularEntity
import kr.dagger.domain.mapper.Mapper
import kr.dagger.domain.model.MoviePopular
import kr.dagger.domain.model.MoviePopularDetails

class MoviePopularDtoMapper : Mapper<MoviePopularEntity, MoviePopular> {

	override fun convert(fromObject: MoviePopularEntity): MoviePopular {
		return MoviePopular(
			page = fromObject.page,
			results = fromObject.result.map {
				MoviePopularDetails(
					adult = it.adult,
					backdrop_path = it.backdropPath,
					id = it.id,
					original_language = it.originalLanguage,
					original_title = it.originalTitle,
					overview = it.overview,
					poster_path = it.posterPath,
					release_date = it.releaseDate,
					title = it.title,
					video = it.video,
					vote_average = it.voteAverage,
					vote_count = it.voteCount
				)
			},
			total_pages = fromObject.totalPages,
			total_results = fromObject.totalResults
		)
	}
}