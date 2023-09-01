package com.example.islandofhvar.data

import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {
    //@GET("olive_oils_with_images_data.json")
    @GET("db.json")
    suspend fun getProducts(): Response<List<Product>>
}