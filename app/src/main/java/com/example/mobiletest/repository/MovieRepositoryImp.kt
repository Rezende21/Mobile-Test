package com.example.mobiletest.repository

import androidx.lifecycle.LiveData
import com.example.mobiletest.data.local.Movie
import com.example.mobiletest.data.local.MovieDao
import com.example.mobiletest.data.remote.MovieApi
import com.example.mobiletest.data.remote.Results
import com.example.mobiletest.data.remote.ServiceApi
import com.example.mobiletest.state.ResourceState
import java.lang.Exception
import javax.inject.Inject


class MovieRepositoryImp @Inject constructor(
    private val api: ServiceApi,
    private val dao: MovieDao
) : MovieRepository {

    override suspend fun addMovieToDB(movie: Movie) {
        return dao.addMovie(movie)
    }

    override fun listAllMovieFromDB(): LiveData<List<Movie>> {
        return dao.readAllData()
    }

    override suspend fun listAllMovieFromApi(): ResourceState<Results> {
        return try {
            val response = api.listMovie()
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let ResourceState.Success(it)
                } ?: ResourceState.Error("Erro", null)
            } else {
                ResourceState.Error("Error", null)
            }
        } catch (e : Exception) {
            ResourceState.Error("não foi possivel acessar o servidor tente novamente mais tarde", null)
        }
    }

    override suspend fun getSingleMovieFromApi(movieId : String): ResourceState<MovieApi> {
        return try {
            val response = api.getMovie(movieId)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let ResourceState.Success(it)
                } ?: ResourceState.Error("Erro", null)
            } else {
                ResourceState.Error("Error", null)
            }
        } catch (e : Exception) {
            ResourceState.Error("Nao foi possivel acessar o servidor", null)
        }
    }

}