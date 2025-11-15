package com.vikmanz.data.repositories

import com.vikmanz.data.api.RetrofitClient
import com.vikmanz.data.api.WeatherAPI
import com.vikmanz.data.dto.ForecastDTO
import retrofit2.Call

object WeatherRepository {

    private val api: WeatherAPI = RetrofitClient.client.create(WeatherAPI::class.java)

    fun getWeather(city: String, date: String): Call<ForecastDTO> = api.getForecast(
       query =  city,
       days = 1,
       date = date
    )

}