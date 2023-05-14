package com.example.catnews.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.catnews.BuildConfig
import com.example.catnews.R
import java.text.SimpleDateFormat
import java.util.*

fun ImageView.setImage(url: String) {
    Glide.with(this).load("${BuildConfig.BASE_URL}${url}")
        .transition(DrawableTransitionOptions.withCrossFade())
        .placeholder(R.drawable.placeholder)
        .into(this)
}

fun String.getTimeAgo(): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    dateFormat.timeZone = TimeZone.getTimeZone("UTC")

    val time = dateFormat.parse(this)?.time ?: return ""
    val currentTime = System.currentTimeMillis()
    val diff = currentTime - time

    val minute = 60 * 1000L
    val hour = 60 * minute
    val day = 24 * hour
    val week = 7 * day
    val month = 30 * day
    val year = 365 * day

    return when {
        diff < minute -> "Just now"
        diff < hour -> "${diff / minute} min ago"
        diff < day -> "${diff / hour} h ago"
        diff < 2 * day -> "Yesterday"
        diff < week -> "${diff / day} d ago"
        diff < month -> "${diff / week} w ago"
        diff < year -> "${diff / month} mon ago"
        else -> "${diff / year} y ago"
    }
}