package com.example.proyecto_falomir_herrero_miguel.model

import androidx.annotation.StringRes

class Car(
    vehicleType: Int,
    modelId: Int,
    brandId: Int,
    hasGPS: Int,
    @StringRes val fuelId: Int
) : Vehicle(vehicleType, modelId, brandId, hasGPS)