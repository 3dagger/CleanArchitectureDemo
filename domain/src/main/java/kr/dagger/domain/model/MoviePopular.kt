package kr.dagger.domain.model

data class MoviePopular(
	val page: Int,
	val results: List<MoviePopularDetails>,
	val total_pages: Int,
	val total_results: Int
)
