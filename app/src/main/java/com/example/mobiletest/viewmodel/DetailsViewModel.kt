package com.example.mobiletest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobiletest.model.MovieApi
import com.example.mobiletest.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class DetailsViewModel : ViewModel(){

    private val repository = MovieRepository()
    val resultado : MutableLiveData<Response<MovieApi>> = MutableLiveData()

    fun fech(id: Int) {
        viewModelScope.launch {
            val busca = repository.fetch(id)
            resultado.value = busca
        }
    }

}