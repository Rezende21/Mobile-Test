package com.example.mobiletest.repository

import androidx.lifecycle.LiveData
import com.example.mobiletest.data.Movie
import com.example.mobiletest.data.MovieDao

class MovieRepository(private val movieDao: MovieDao) {

    val readAllData: LiveData<List<Movie>> = movieDao.readAllData()

    suspend fun addMovie(movie: Movie) {
        movieDao.addMovie(movie)
    }

}