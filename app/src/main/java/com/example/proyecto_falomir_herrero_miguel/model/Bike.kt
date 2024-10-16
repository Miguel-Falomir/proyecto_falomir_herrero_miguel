package com.example.proyecto_falomir_herrero_miguel.model

import androidx.annotation.StringRes

class Bike(
    modelId: Int,
    brandId: Int,
    hasGPS: Int,
    @StringRes val sizeId: Int
) : Vehicle(modelId, brandId, hasGPS)
