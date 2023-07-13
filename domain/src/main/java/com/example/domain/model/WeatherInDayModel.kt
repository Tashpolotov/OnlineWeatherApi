package com.example.domain.model

data class WeatherInDayModel(
    val country : String,
    val temp : Float,
    val date : Long,
    val state :String,
    val rainFall : Float,
    val wind : Float,
    val humidity: Float
)
