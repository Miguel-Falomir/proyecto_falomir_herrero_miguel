package com.example.proyecto_falomir_herrero_miguel.model

import androidx.annotation.StringRes

class Car(
    modelId: Int,
    brandId: Int,
    hasGPS: Boolean,
    @StringRes val fuelId: Int
) : Vehicle(modelId, brandId, hasGPS)