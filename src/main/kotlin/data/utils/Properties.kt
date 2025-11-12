package com.vikmanz.data.utils

import java.io.FileInputStream
import java.util.Properties

object Properties {

    private val properties = Properties().apply {
        load(FileInputStream("config.properties"))
    }

    val apiKey: String =
        properties.getProperty("api.key").ifBlank {
            error("Please set api.key in config.properties")
        }

}