package com.example.mobiletest.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mobiletest.data.local.Movie
import com.example.mobiletest.data.remote.MovieApi
import com.example.mobiletest.data.remote.Results
import com.example.mobiletest.data.remote.VideoResults
import com.example.mobiletest.state.ResourceState

class FakeRepository : MovieRepository {

    private val movies = mutableListOf<Movie>()
    private val showAllMovie = MutableLiveData<List<Movie>>()
    private var neteworkError = false

    private fun refreshLiveData() {
        showAllMovie.postValue(movies)
    }

    fun setNetworkError(value : Boolean) {
        neteworkError = value
    }

    override suspend fun addMovieToDB(movie: Movie) {
        movies.add(movie)
        refreshLiveData()
    }

    override fun listAllMovieFromDB(): LiveData<List<Movie>> {
        return showAllMovie
    }

    override suspend fun listAllMovieFromApi(): ResourceState<Results> {
        val results = Results(1, listOf())
        return if (neteworkError) {
            ResourceState.Error("Error", null)
        } else {
            ResourceState.Success(results)
        }
    }

    override suspend fun getSingleMovieFromApi(movieId: String): ResourceState<MovieApi> {
        val movieApi = MovieApi("teste", "teste", "teste", 15, "teste", "teste", 15.42, VideoResults())
        return if (neteworkError) {
            ResourceState.Error("Error", null)
        } else {
            ResourceState.Success(movieApi)
        }
    }


}