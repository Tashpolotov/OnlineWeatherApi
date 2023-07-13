package com.example.presenter.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.WeatherInDayModel
import com.example.domain.model.WeatherInHourModel
import com.example.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val repository: WeatherRepository): ViewModel() {

    private val _weatherInDay = MutableStateFlow<WeatherInDayModel?>(null)
    val weatherInDay: StateFlow<WeatherInDayModel?> = _weatherInDay

    private val _weatherSevenDays = MutableStateFlow<List<WeatherInDayModel>>(emptyList())
    val weatherSevenDays: StateFlow<List<WeatherInDayModel>> = _weatherSevenDays

    private val _weatherInHourToday = MutableStateFlow<List<WeatherInHourModel>>(emptyList())
    val weatherInHourToday: StateFlow<List<WeatherInHourModel>> = _weatherInHourToday

    private val _weatherInHourTomorrow = MutableStateFlow<List<WeatherInHourModel>>(emptyList())
    val weatherInHourTomorrow: StateFlow<List<WeatherInHourModel>> = _weatherInHourTomorrow

    fun getLoadWeatherToday() {
        viewModelScope.launch {
            val result = repository.getWeatherToday()
            _weatherInDay.value = result.value
        }
    }

    fun getLoadWeatherForWeek() {
        viewModelScope.launch {
            val result = repository.getWeatherSevenDays()
            _weatherSevenDays.value = result.value
        }
    }

    fun getLoadWeatherInHourToday() {
        viewModelScope.launch {
            val result = repository.getWeatherInHourToday()
            _weatherInHourToday.value = result.value
            Log.e("WeatherViewModel", "Loaded weather in hour today: ${_weatherInHourToday.value}")
        }
    }

    fun getLoadWeatherInHourTomorrow() {
        viewModelScope.launch {
            val result = repository.getWeatherInHourTomorrow()
            _weatherInHourTomorrow.value = result.value
        }
    }
}