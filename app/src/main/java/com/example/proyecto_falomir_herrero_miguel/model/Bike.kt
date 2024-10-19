package com.example.proyecto_falomir_herrero_miguel.model

import androidx.annotation.StringRes

class Bike(
    vehicleType: Int,
    modelId: Int,
    brandId: Int,
    hasGPS: Int,
    @StringRes val sizeId: Int
) : Vehicle(vehicleType, modelId, brandId, hasGPS)
