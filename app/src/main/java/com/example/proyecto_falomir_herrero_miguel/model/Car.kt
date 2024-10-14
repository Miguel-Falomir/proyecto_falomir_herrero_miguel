package com.example.proyecto_falomir_herrero_miguel.model

import androidx.annotation.StringRes

data class Car(
    @StringRes val modelId: Int,
    @StringRes val brandId: Int,
    @StringRes val fuelId: Int
)
