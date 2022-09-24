package com.example.mobiletest.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey(autoGenerate = false)
    val id : Int,
    val Title: String,
    val Poster: String,
)
