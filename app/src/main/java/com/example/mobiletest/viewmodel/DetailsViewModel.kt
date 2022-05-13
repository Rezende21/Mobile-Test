package com.example.mobiletest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobiletest.model.MovieApi
import com.example.mobiletest.repository.MovieRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class DetailsViewModel : ViewModel(){

    private val repository = MovieRepository()
    val resultado : MutableLiveData<Response<MovieApi>> = MutableLiveData()

    fun fech(id: Int, API_KEY : String, TAG : String) {
        viewModelScope.launch {
            val busca = repository.fetch(id, API_KEY, TAG)
            resultado.value = busca
        }
    }

}