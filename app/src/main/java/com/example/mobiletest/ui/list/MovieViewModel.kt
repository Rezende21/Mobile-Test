package com.example.mobiletest.ui.list

import androidx.lifecycle.*
import com.example.mobiletest.data.remote.Results
import com.example.mobiletest.repository.MovieRepository
import com.example.mobiletest.state.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _results = MutableLiveData<ResourceState<Results>>()
    val results : LiveData<ResourceState<Results>> = _results

    fun listMovie() {
        viewModelScope.launch {
            _results.value = ResourceState.Loading()
            try {
                val response = repository.listAllMovieFromApi()
                _results.postValue(response)
            } catch (e : Exception) {
                _results.value = ResourceState.Error("Erro nao recuperar dados", null)
            }

        }
    }
}
