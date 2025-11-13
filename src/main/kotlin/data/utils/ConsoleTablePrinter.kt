package com.vikmanz.data.utils

import com.vikmanz.data.dto.CitySpecs

object ConsoleTablePrinter {

    private const val INFO_BLOCK_LENGTH = 40
    private const val NAME_PADDING = 2

    fun printWeatherTable(list: List<CitySpecs>) {

        val header = "%-12s | %-12s | %-10s | %-10s | %-10s | %-18s | %-14s".format(
            "City", "Date", "TempMin", "TempMax", "Humidity", "Wind speed (km/h)", "Wind direction"
        )
        val separator = "-".repeat(header.length)

        fun toLine(city: CitySpecs) = with(city) {
            "%-12s | %-12s | %-10.1f | %-10.1f | %-10.1f | %-18.1f | %-14s".format(
                name, date, tempMin, tempMax, humidity, windSpeed, windDirection
            )
        }

        println("\n$header\n$separator")
        list.forEach { println(toLine(it)) }
        println()
    }

    fun printWeatherBlocksTable(date: String, list: List<CitySpecs>) {
        val maxCityNameLength = list.maxOf { it.name.length } + NAME_PADDING

        val header = "%-${maxCityNameLength}s| %-12s".format(
            "City", date
        )

        val separator = "-".repeat(maxCityNameLength + INFO_BLOCK_LENGTH)

        fun toLine(spec: CitySpecs): String {
            val nameSpace = " ".repeat(maxCityNameLength)
            return """
            ${spec.name.padEnd(maxCityNameLength)}${"| ○ Minimum Temperature (°C): ${spec.tempMin}".padEnd(INFO_BLOCK_LENGTH) }
            $nameSpace${"| ○ Maximum Temperature (°C): ${spec.tempMax}".padEnd(INFO_BLOCK_LENGTH) }
            $nameSpace${"| ○ Humidity (%): ${spec.humidity}".padEnd(INFO_BLOCK_LENGTH) }
            $nameSpace${"| ○ Wind Speed (kph): ${spec.windSpeed}".padEnd(INFO_BLOCK_LENGTH) }
            $nameSpace${"| ○ Wind Direction: ${spec.windDirection}".padEnd(INFO_BLOCK_LENGTH) }
            $separator
        """.trimIndent()
        }

        println("\n$header\n$separator")
        list.forEach { println(toLine(it)) }
        println()
    }

}