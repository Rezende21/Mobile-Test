package com.example.mobiletest.repository

import com.example.mobiletest.apiMovie.Module
import com.example.mobiletest.apiMovie.ServiceApi
import com.example.mobiletest.model.MovieApi
import com.example.mobiletest.model.Results
import retrofit2.Response


class MovieRepository {

    suspend fun listMovie(): Response<Results> {
       return Module.api.listMovie()
    }

    suspend fun fetch(id: Int) : Response<MovieApi> {
        return Module.api.getMovie(id)
    }

}