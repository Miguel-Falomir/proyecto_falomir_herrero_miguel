package com.example.proyecto_falomir_herrero_miguel.model

import androidx.annotation.StringRes

data class Scooter(
    @StringRes val modelId: Int,
    @StringRes val brandId: Int,
    val hasGPS: Boolean
)
