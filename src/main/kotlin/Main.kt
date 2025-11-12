package com.vikmanz

import com.vikmanz.data.services.WeatherService
import com.vikmanz.data.utils.ConsoleTablePrinter

fun main() {
    val list = WeatherService.getWeatherList()
    ConsoleTablePrinter.printWeatherTable(list)
}