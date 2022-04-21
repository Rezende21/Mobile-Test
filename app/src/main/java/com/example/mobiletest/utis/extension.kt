package com.example.mobiletest.utis

import android.widget.ImageView
import com.bumptech.glide.Glide

fun loadImage(imageView: ImageView, poster_path : String) {
    Glide.with(imageView.context)
        .load(poster_path)
        .into(imageView)
}