package com.weatherapp.models

import java.io.Serializable

data class Main(
    val temp: Float,
    val pressure: Int,
    val humidity: Int,
    val temp_min: Float,
    val temp_max: Float
) : Serializable