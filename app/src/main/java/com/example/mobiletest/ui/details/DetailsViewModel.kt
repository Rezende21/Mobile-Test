package com.example.mobiletest.ui.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobiletest.data.remote.MovieApi
import com.example.mobiletest.repository.MovieRepository
import com.example.mobiletest.state.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel(){

    private val _result = MutableLiveData<ResourceState<MovieApi>>()
    val result : LiveData<ResourceState<MovieApi>> = _result

    fun fech(movieId: String) {
        if (movieId.isEmpty()) {
            ResourceState.Error("Selecione o filme novamente Pfv", null)
        } else {
            _result.value = ResourceState.Loading()
            viewModelScope.launch {
                getSingleMovieFromApi(movieId)
            }
        }
    }

    suspend fun getSingleMovieFromApi(movieId: String) {
        viewModelScope.launch {
            try {
                val search = repository.getSingleMovieFromApi(movieId)
                _result.postValue(search)
            } catch (e: Exception) {
                when(e) {
                    is IOException -> _result.value =
                        ResourceState.Error("Erro de conexão com a internet ")
                    else -> _result.value = ResourceState.Error("Erro na conversão")
                }
            }
        }
    }
}