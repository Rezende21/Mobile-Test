package com.example.mobiletest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mobiletest.data.local.Movie
import com.example.mobiletest.data.local.MovieDao

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase(){

    abstract fun getDataBaseInstace() : MovieDao

}