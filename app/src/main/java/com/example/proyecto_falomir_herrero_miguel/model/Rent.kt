package com.example.proyecto_falomir_herrero_miguel.model

import androidx.annotation.StringRes

class Rent (
    @StringRes val dateId: Int,
    @StringRes val rentDaysId: Int,
    @StringRes val priceId: Int,
    val vehicle: Vehicle,
    val user: User
)