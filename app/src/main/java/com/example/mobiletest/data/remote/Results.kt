package com.example.mobiletest.data.remote

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Results(
    @SerializedName("page")
    val page : Int,

    @SerializedName("results")
    val results : List<MovieApi>
) : Serializable
