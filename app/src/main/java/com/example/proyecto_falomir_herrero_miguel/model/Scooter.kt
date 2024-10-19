package com.example.proyecto_falomir_herrero_miguel.model

import androidx.annotation.StringRes

class Scooter(
    vehicleType: Int,
    modelId: Int,
    brandId: Int,
    hasGPS: Int
) : Vehicle(vehicleType, modelId, brandId, hasGPS)
