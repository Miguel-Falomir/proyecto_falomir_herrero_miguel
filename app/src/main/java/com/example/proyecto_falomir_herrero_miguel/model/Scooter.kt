package com.example.proyecto_falomir_herrero_miguel.model

import androidx.annotation.StringRes

class Scooter(
    modelId: Int,
    brandId: Int,
    hasGPS: Boolean,
    @StringRes val fuelId: Int
) : Vehicle(modelId, brandId, hasGPS)
