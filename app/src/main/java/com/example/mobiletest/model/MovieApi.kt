package com.example.mobiletest.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieApi(
    @SerializedName("poster_path")
    val poster_path : String,

    @SerializedName("overview")
    val overview : String,

    @SerializedName("Release_date")
    val release_date : String,

    @SerializedName("id")
    val id : Int,

    @SerializedName("original_language")
    val original_language : String,

    @SerializedName("title")
    val title : String,

    @SerializedName("vote_average")
    val vote_average : Double,

    @SerializedName("video")
    val video : Boolean

) : Serializable
