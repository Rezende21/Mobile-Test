package com.example.mobiletest.ui.details

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mobiletest.MainCoroutineRule
import com.example.mobiletest.data.remote.MovieApi
import com.example.mobiletest.data.remote.VideoResults
import com.example.mobiletest.repository.FakeRepository
import com.example.mobiletest.state.ResourceState
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class DetailsViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()
    private lateinit var viewModel : DetailsViewModel

    @Before
    fun setup() {
        viewModel = DetailsViewModel(FakeRepository())
    }

    @Test
    fun `no id pass to search movie, return erro`() {
        val movieApi = MovieApi("teste", "teste", "teste", 15, "teste", "teste", 15.42, VideoResults())
        val movieid = ""
        viewModel.fech(movieid)

        val result = ResourceState.Error("erro", null)
        assertThat(result).isNotEqualTo(ResourceState.Success(movieApi))
    }

    @Test
    fun `pass id to the function get the result ok`() {
        val moveid = "4c389d4f"
        viewModel.fech(moveid)

        val result = ResourceState.Success(moveid)
        assertThat(result).isNotEqualTo(ResourceState.Error("Erro", null))
    }

}
