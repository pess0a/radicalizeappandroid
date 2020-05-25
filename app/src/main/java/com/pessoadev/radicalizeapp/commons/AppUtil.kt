package com.pessoadev.radicalizeapp.commons

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView

object AppUtil {

    fun loadImage(context: Context, url: String, image: AppCompatImageView) {
        GlideApp.with(context)
            .load(url)
            .into(image)
    }
}