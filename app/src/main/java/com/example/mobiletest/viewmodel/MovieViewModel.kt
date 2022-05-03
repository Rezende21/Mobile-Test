package com.example.mobiletest.viewmodel

import androidx.lifecycle.*
import com.example.mobiletest.model.MovieApi
import com.example.mobiletest.model.Results
import com.example.mobiletest.repository.MovieRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MovieViewModel() : ViewModel() {

    private val repository = MovieRepository()
    val responsabilidade : MutableLiveData<Response<Results>> = MutableLiveData()


    fun listMovie() {
        viewModelScope.launch {
            val response = repository.listMovie()
              responsabilidade.value = response
        }
    }
}
