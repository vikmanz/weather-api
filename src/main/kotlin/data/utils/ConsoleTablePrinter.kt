package com.vikmanz.data.utils

import com.vikmanz.data.dto.CitySpecs

object ConsoleTablePrinter {

    fun printWeatherTable(list: List<CitySpecs>) {

        val header = "%-12s | %-12s | %-10s | %-10s | %-10s | %-16s | %-14s".format(
            "City", "Date", "TempMin", "TempMax", "Humidity", "Wind speed (m/h)", "Wind direction"
        )
        val separator = "-".repeat(header.length)

        fun toLine(city: CitySpecs) = with(city) {
            "%-12s | %-12s | %-10.1f | %-10.1f | %-10.1f | %-16.1f | %-14s".format(
                name, date, tempMin, tempMax, humidity, windSpeed, windDirection
            )
        }

        println("\n$header\n$separator")
        list.forEach { println(toLine(it)) }
        println()
    }

}