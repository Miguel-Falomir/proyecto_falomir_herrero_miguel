package com.example.proyecto_falomir_herrero_miguel.model

data class ScooterUIState(
    override val brand: String = "",
    override val model: String = "",
    override val hasGPS: Boolean = false

) : VehicleUIState(brand, model, hasGPS)
