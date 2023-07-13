package com.example.onlineweatherapi.module

import com.example.data.repository.RetrofitClient
import com.example.data.repository.WeatherRepositoryImpl
import com.example.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class WeatherModule {

    @Provides
    fun getRepository(retrofitClient: RetrofitClient) : WeatherRepository{
        return WeatherRepositoryImpl(retrofitClient)
    }
}