package com.vikmanz.data.utils

import java.io.FileInputStream
import java.util.Properties

private const val CONFIG_FILENAME = "config.properties"

object Properties {

    private val properties = Properties().apply {
        load(FileInputStream(CONFIG_FILENAME))
    }

    val apiURL: String = getString(
        key = "api.url",
        example = "api.url=url.com/v1/"
    )

    val apiKey: String = getString(
        key = "api.key",
        example = "api.key=12345"
    )

    val cityList: List<String> =
        getString(
            key = "cities",
            example = "cities=Chisinau,Madrid,Kyiv"
        ).split(",")

    fun getString(key: String, example: String): String {
        return properties.getProperty(key, "").ifBlank {
            error("Please specify $key in $CONFIG_FILENAME file in the format '$example'")
        }
    }

}