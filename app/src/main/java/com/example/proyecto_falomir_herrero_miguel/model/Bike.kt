package com.example.proyecto_falomir_herrero_miguel.model

data class Bike(
    override val brand: String = "",
    override val model: String = "",
    override val hasGPS: Boolean = false,
    val size: String = ""

) : Vehicle(brand, model, hasGPS)
