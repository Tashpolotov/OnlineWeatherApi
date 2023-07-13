package com.example.data.repository

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

    interface WeatherApi {

        @GET("v1/current.json")
        suspend fun getWeather(
            @Query("country") country: String,
            @Header("Authorization") auth: String = "5448afc2bb61433ca8263622222212"

        ) : Response<WeatherResponse>
    }