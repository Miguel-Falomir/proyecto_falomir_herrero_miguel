package com.example.proyecto_falomir_herrero_miguel.model

data class Rent (
    val date: String = "",
    val rentDays: String = "",
    val price: Double = 0.0,
    val vehicle: Vehicle = Car(),
    val user: User = User()
)