package com.example.mobiletest.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Results(
    @SerializedName("page")
    val page : Int,

    @SerializedName("results")
    val results : List<MovieApi>
) : Serializable
