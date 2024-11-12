package com.example.proyecto_falomir_herrero_miguel.model

data class CarUIState(
    override val brand: String = "",
    override val model: String = "",
    override val hasGPS: Boolean = false,
    val fuel: String = ""

) : VehicleUIState(brand, model, hasGPS)