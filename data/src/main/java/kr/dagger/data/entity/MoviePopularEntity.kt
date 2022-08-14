package kr.dagger.data.entity

import com.google.gson.annotations.SerializedName

data class MoviePopularEntity(
	@SerializedName("page") val page: Int,
	@SerializedName("results") val result: List<MoviePopularDetailsEntity>,
	@SerializedName("total_pages") val totalPages: Int,
	@SerializedName("total_results") val totalResults: Int
)
