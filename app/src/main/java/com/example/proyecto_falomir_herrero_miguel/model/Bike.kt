package com.example.proyecto_falomir_herrero_miguel.model

import androidx.annotation.StringRes

data class Bike(
    @StringRes val modelId: Int,
    @StringRes val brandId: Int,
    @StringRes val sizeId: Int
)
