package com.example.mobiletest.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMovie(movie: Movie)

    @Query("SELECT * FROM Movie ORDER bY id ASC")
    fun readAllData() : LiveData<List<Movie>>

    @Delete
    suspend fun deleteMovie(movie: Movie)
}