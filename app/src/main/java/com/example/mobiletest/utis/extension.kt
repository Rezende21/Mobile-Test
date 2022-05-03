package com.example.mobiletest.utis

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.mobiletest.utis.Constants.BASE_URL_IMAGE

fun loadImage(imageView: ImageView, poster_path : String) {
    Glide.with(imageView.context)
        .load(BASE_URL_IMAGE + poster_path)
        .into(imageView)
}