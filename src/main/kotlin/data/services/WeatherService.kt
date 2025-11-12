package com.vikmanz.data.services

import com.vikmanz.data.dto.CitySpecs
import com.vikmanz.data.repositories.WeatherRepository
import com.vikmanz.domain.model.City
import kotlinx.coroutines.runBlocking
import retrofit2.awaitResponse

object WeatherService {

    val repo = WeatherRepository

    fun getWeatherList(): List<CitySpecs> = City.entries.mapNotNull { city ->
        runBlocking {
            repo.getWeather(city).awaitResponse().body()?.toCitySpecs()
        }
    }

}