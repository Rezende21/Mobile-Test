package com.example.mobiletest.data.remote

import com.example.mobiletest.BuildConfig
import com.example.mobiletest.utis.Constants.TAG_VIDEOS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceApi {

    @GET("movie/popular")
    suspend fun listMovie(
        @Query("api_key") api_key : String = BuildConfig.API_KEY
    ) : Response<Results>

    @GET("movie/{movie_id}")
    suspend fun getMovie(
        @Path("movie_id") movie_id : String,
        @Query("api_key") api_key : String = BuildConfig.API_KEY,
        @Query("append_to_response") append_to_response : String = TAG_VIDEOS
    ) : Response<MovieApi>
}