package com.vikmanz.data.services

import com.vikmanz.data.dto.CitySpecs
import com.vikmanz.data.repositories.WeatherRepository
import com.vikmanz.data.utils.Properties
import kotlinx.coroutines.runBlocking
import retrofit2.awaitResponse
import java.time.LocalDate
import java.time.temporal.ChronoUnit

object WeatherService {

    val repo = WeatherRepository

    fun getWeatherList(): List<CitySpecs> {
        val date = LocalDate.now().plus(1, ChronoUnit.DAYS).toString()
        return Properties.cityList.mapNotNull { city ->
            runBlocking {
                repo.getWeather(city, date).awaitResponse().body()?.toCitySpecs()
            }
        }
    }

}