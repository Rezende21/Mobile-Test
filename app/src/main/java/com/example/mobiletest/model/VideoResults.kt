package com.example.mobiletest.model

import com.google.gson.annotations.SerializedName

data class VideoResults(

    @SerializedName("results")
    val results : List<VideoMovie>

)
