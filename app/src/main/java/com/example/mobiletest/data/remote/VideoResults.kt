package com.example.mobiletest.data.remote

import com.google.gson.annotations.SerializedName

data class VideoResults(

    @SerializedName("results")
    val results: List<VideoMovie>? = null

)
