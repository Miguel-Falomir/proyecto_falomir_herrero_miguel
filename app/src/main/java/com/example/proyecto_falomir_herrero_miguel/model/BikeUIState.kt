package com.example.proyecto_falomir_herrero_miguel.model

data class BikeUIState(
    override val brand: String = "",
    override val model: String = "",
    override val hasGPS: Boolean = false,
    val size: String = ""

) : VehicleUIState(brand, model, hasGPS)
