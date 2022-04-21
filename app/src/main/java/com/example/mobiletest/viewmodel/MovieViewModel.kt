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

//    class Factory(val repository: MovieRepository) : ViewModelProvider.Factory {
//        override fun <T : ViewModel> create(modelClass: Class<T>): T {
//            if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
//                return MovieViewModel(repository) as T
//            }
//            throw IllegalAccessException("Unable to construct MovieVewModel")
//        }
//
//    }
}
