package com.example.proyecto_falomir_herrero_miguel.model

import androidx.annotation.StringRes

open class Vehicle(
    @StringRes val modelId: Int,
    @StringRes val brandId: Int,
    val hasGPS: Boolean
)
