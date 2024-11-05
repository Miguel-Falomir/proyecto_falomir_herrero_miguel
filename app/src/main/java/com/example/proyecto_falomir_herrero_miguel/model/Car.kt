package com.example.proyecto_falomir_herrero_miguel.model

import androidx.annotation.StringRes

data class Car(
    override val vehicle: String,
    override val model: String,
    override val brand: String,
    override val hasGPS: Boolean,
    val fuel: String

) : Vehicle(vehicle, model, brand, hasGPS)