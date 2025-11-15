package com.vikmanz.data.dto

import com.google.gson.annotations.SerializedName

data class ForecastDTO(
    val location: Location,
    val forecast: Forecast
) {
    fun toCitySpecs() = with(forecast.forecastDays.first()) {
        CitySpecs(
            name = location.name,
            date = date,
            tempMin = day.minTemp,
            tempMax = day.maxTemp,
            humidity = day.humidity,
            windSpeed = day.maxWindSpeed,
            windDirection = hour.first { it.windSpeed == day.maxWindSpeed }.windDirection
        )
    }
}

data class Location(
    val name: String
)

data class Forecast(
    @SerializedName("forecastday")
    val forecastDays: List<ForecastDay>
)

data class ForecastDay(
    val date: String,
    val day: Day,
    val hour: List<Hour>
)

data class Day(
    @SerializedName("mintemp_c")
    val minTemp: Double,
    @SerializedName("maxtemp_c")
    val maxTemp: Double,
    @SerializedName("avghumidity")
    val humidity: Double,
    @SerializedName("maxwind_kph")
    val maxWindSpeed: Double
)

data class Hour(
    @SerializedName("wind_kph")
    val windSpeed: Double,
    @SerializedName("wind_dir")
    val windDirection: String

)

