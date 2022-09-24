package com.example.mobiletest.repository

import androidx.lifecycle.LiveData
import com.example.mobiletest.data.local.Movie
import com.example.mobiletest.data.remote.MovieApi
import com.example.mobiletest.data.remote.Results
import com.example.mobiletest.state.ResourceState

interface MovieRepository {

    suspend fun addMovieToDB(movie : Movie)
    fun listAllMovieFromDB() : LiveData<List<Movie>>

    suspend fun listAllMovieFromApi() : ResourceState<Results>
    suspend fun getSingleMovieFromApi(movieId : String) : ResourceState<MovieApi>
}