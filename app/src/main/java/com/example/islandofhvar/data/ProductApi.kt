package com.example.islandofhvar.data

import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {
    @GET("db.json")
    suspend fun getProducts(): Response<List<Product>>
}