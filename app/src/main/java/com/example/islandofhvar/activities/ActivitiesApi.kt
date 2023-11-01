package com.example.islandofhvar.activities

import retrofit2.Response
import retrofit2.http.GET

interface ActivitiesApi {
    @GET("activiites_data.json")
    suspend fun getActivities(): Response<List<Activities>>
}