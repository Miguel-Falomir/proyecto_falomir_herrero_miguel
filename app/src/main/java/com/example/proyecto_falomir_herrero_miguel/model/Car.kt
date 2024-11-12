package com.example.proyecto_falomir_herrero_miguel.model

data class Car(
    override val brand: String = "",
    override val model: String = "",
    override val hasGPS: Boolean = false,
    val fuel: String = ""

) : Vehicle(brand, model, hasGPS)