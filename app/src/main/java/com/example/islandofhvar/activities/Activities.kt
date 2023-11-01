package com.example.islandofhvar.activities

import com.squareup.moshi.Json

data class Activities(
    @Json(name = "activityName")
    val name: String,
    val imageFile: String,
    val description: String,
    val duration: Int,
    val price: Int
)