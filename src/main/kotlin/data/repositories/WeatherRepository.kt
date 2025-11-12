package com.vikmanz.data.repositories

import com.vikmanz.data.api.RetrofitClient
import com.vikmanz.data.api.WeatherAPI
import com.vikmanz.domain.model.City
import data.dto.ForecastDTO
import retrofit2.Call
import java.time.LocalDate
import java.time.temporal.ChronoUnit

object WeatherRepository {

    private val api: WeatherAPI = RetrofitClient.client.create(WeatherAPI::class.java)

    fun getWeather(city: City): Call<ForecastDTO> = api.getForecast(
       query =  city.name,
       days = 1,
       date = LocalDate.now().plus(1, ChronoUnit.DAYS).toString()
    )

}