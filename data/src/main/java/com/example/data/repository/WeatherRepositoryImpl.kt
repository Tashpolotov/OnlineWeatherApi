package com.example.data.repository

import com.example.domain.model.WeatherInDayModel
import com.example.domain.model.WeatherInHourModel
import com.example.domain.repository.WeatherRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val retrofitClient: RetrofitClient):WeatherRepository {


    private val weatherToday = MutableStateFlow<WeatherInDayModel?>(null)

    private val weatherSevenDay = MutableStateFlow(emptyList<WeatherInDayModel>())

    private val weatherInHourToday = MutableStateFlow(emptyList<WeatherInHourModel>())

    private val weatherInHourTomorrow = MutableStateFlow(emptyList<WeatherInHourModel>())

    override fun getWeatherToday(): StateFlow<WeatherInDayModel?> {
        return weatherToday

    }

    override fun getWeatherSevenDays(): StateFlow<List<WeatherInDayModel>> {
        return weatherSevenDay
    }

    override fun getWeatherInHourToday(): StateFlow<List<WeatherInHourModel>> {
        return weatherInHourToday
    }

    override fun getWeatherInHourTomorrow(): StateFlow<List<WeatherInHourModel>> {
        return weatherInHourTomorrow
    }


    override fun loadWeatherToday() {

    }

    override fun loadWeatherForWeek() {

        }
    }