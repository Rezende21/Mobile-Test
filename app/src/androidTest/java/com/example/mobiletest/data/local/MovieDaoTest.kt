package com.example.mobiletest.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SmallTest
@ExperimentalCoroutinesApi
class MovieDaoTest {

    @get: Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database : MovieDatabase
    private lateinit var dao : MovieDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            MovieDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()
        dao = database.getDataBaseInstace()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertMovieToDatabase() = runBlocking {
        val movie = Movie(1, "Test", "ALguma coisa para representar a URL")
        dao.addMovie(movie)

        val showAllMovie = dao.readAllData().getOrAwaitValue()
        assertThat(showAllMovie).contains(movie)
    }

    @Test
    fun deleteMovideFromDatabase() = runBlocking {
        val movie = Movie(1, "Test", "Teste de banco")
        dao.addMovie(movie)
        dao.deleteMovie(movie)

        val showAllMovie = dao.readAllData().getOrAwaitValue()
        assertThat(showAllMovie).doesNotContain(movie)
    }



}