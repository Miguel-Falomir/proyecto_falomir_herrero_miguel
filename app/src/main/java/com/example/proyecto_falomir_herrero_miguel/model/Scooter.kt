package com.example.proyecto_falomir_herrero_miguel.model

data class Scooter(
    override val brand: String = "",
    override val model: String = "",
    override val hasGPS: Boolean = false

) : Vehicle(brand, model, hasGPS)
