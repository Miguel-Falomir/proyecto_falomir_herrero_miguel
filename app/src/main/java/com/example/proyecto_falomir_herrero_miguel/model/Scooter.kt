package com.example.proyecto_falomir_herrero_miguel.model

import androidx.annotation.StringRes

data class Scooter(
    override val vehicle: String,
    override val model: String,
    override val brand: String,
    override val hasGPS: Boolean

) : Vehicle(vehicle, model, brand, hasGPS)
