package com.example.mobiletest.apiMovie

import com.example.mobiletest.utis.Constants.API_KEY
import com.example.mobiletest.model.Results
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {

    @GET("movie/popular")
    suspend fun listMovie(
        @Query("api_key") api_key : String = API_KEY
    ) : Response<Results>
}