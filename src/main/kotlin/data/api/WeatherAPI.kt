package com.vikmanz.data.api

import data.dto.ForecastDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WeatherAPI {

    @GET("forecast.json")
    @Headers("Content-type: application/json")
    fun getForecast(
        @Query("q") query: String,
        @Query("days") days: Int,
        @Query("dt") date: String,
    ): Call<ForecastDTO>

}