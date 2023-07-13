package com.example.domain.repository


import com.example.domain.model.WeatherInDayModel
import com.example.domain.model.WeatherInHourModel
import kotlinx.coroutines.flow.StateFlow

interface WeatherRepository  {

    fun getWeatherToday() :  StateFlow<WeatherInDayModel?>

    fun getWeatherSevenDays() : StateFlow<List<WeatherInDayModel>>

    fun getWeatherInHourToday() : StateFlow<List<WeatherInHourModel>>

    fun getWeatherInHourTomorrow() : StateFlow<List<WeatherInHourModel>>

    fun loadWeatherToday()

    fun loadWeatherForWeek()

}