package kr.dagger.data.mapper

import kr.dagger.data.entity.MoviePopularDetailsEntity
import kr.dagger.domain.mapper.Mapper
import kr.dagger.domain.model.MoviePopularDetails

class MoviePopularDetailDtoMapper : Mapper<MoviePopularDetailsEntity, MoviePopularDetails> {

	override fun convert(fromObject: MoviePopularDetailsEntity): MoviePopularDetails {
		return MoviePopularDetails(
			adult = fromObject.adult,
			backdrop_path = fromObject.backdropPath,
			id = fromObject.id,
			original_language = fromObject.originalLanguage,
			original_title = fromObject.originalTitle,
			overview = fromObject.overview,
			poster_path = fromObject.posterPath,
			release_date = fromObject.releaseDate,
			title = fromObject.title,
			video = fromObject.video,
			vote_average = fromObject.voteAverage,
			vote_count = fromObject.voteCount
		)
	}
}