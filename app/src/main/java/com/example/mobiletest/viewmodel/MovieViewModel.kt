package com.example.mobiletest.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mobiletest.data.Movie
import com.example.mobiletest.data.MovieDatabase
import com.example.mobiletest.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData : LiveData<List<Movie>>
    private val repository: MovieRepository

    init {
        val movieDao = MovieDatabase.getDatabase(application).MovieDao()
        repository = MovieRepository(movieDao)
        readAllData = repository.readAllData
    }

    fun addMovie(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addMovie(movie)
        }
    }
}