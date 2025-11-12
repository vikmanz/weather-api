package com.vikmanz.data.repositories

import com.vikmanz.data.api.RetrofitClient
import com.vikmanz.data.api.WeatherAPI
import com.vikmanz.domain.model.City
import data.dto.ForecastDTO
import retrofit2.Call

object WeatherRepository {

    private val api: WeatherAPI = RetrofitClient.client.create(WeatherAPI::class.java)

    fun getWeather(city: City): Call<ForecastDTO> = api.getForecast(city.name, 1)

}