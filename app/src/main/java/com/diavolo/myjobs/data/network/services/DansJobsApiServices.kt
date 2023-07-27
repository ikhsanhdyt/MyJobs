package com.diavolo.myjobs.data.network.services

import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Written with passion by Ikhsan Hidayat on 15/07/2023.
 */
interface DansJobsApiServices {
//    @GET("genre/movie/list")
//    suspend fun getGenreList(): GenreListResponse
//
//    @GET("discover/movie")
//    suspend fun getMovieList(
//        @Query("with_genres") genreId: String,
//        @Query("page") page: Int
//    ): MovieListResponse
//
//    @GET("movie/{movie_id}/videos")
//    suspend fun getTrailerList(@Path("movie_id") movieId: String): TrailerResponse
//
//    @GET("movie/{movie_id}/reviews")
//    suspend fun getReviewList(@Path("movie_id") movieId: String,@Query("page") page: Int): ReviewListResponse
//

    companion object {
        @JvmStatic
        operator fun invoke(chuckerInterceptor: ChuckerInterceptor): DansJobsApiServices {
            val authInterceptor = Interceptor {
                val requestBuilder = it.request().newBuilder()
                requestBuilder.addHeader(
                    "Authorization",
                    "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzM2I2MjgwZGFlZGZlYzcxYzY0NDRhNzY1NGY4NDU5YyIsInN1YiI6IjVlNTRjZWI5MTU5NTlmMDAxM2E3ZDI0OCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.NJasySRlfjub4Tt1LvyF7Yf5-TkOb7Xe-Bhno2BdxuM"
                )
                it.proceed(requestBuilder.build())
            }

            val okHttpClient = OkHttpClient.Builder().addInterceptor(chuckerInterceptor)
                .addInterceptor(authInterceptor).connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS).build()

            val retrofit =
                Retrofit.Builder().baseUrl("http://dev3.dansmultipro.co.id/").addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient).build()
            return retrofit.create(DansJobsApiServices::class.java)
        }
    }
}