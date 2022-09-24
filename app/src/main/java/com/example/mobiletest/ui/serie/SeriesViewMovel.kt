package com.example.mobiletest.ui.serie

import androidx.lifecycle.ViewModel
import com.example.mobiletest.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SeriesViewMovel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

}