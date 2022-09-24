package com.example.mobiletest.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMovie(movie: Movie)

    @Query("SELECT * FROM Movie ORDER bY id ASC")
    fun readAllData() : LiveData<List<Movie>>
}