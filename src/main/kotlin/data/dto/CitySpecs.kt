package com.vikmanz.data.dto

data class CitySpecs(
    val name: String,
    val date: String,
    val tempMin: Double,
    val tempMax: Double,
    val humidity: Double,
    val windSpeed: Double,
    val windDirection: String,
)