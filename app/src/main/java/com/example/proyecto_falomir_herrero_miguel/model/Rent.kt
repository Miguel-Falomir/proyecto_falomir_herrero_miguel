package com.example.proyecto_falomir_herrero_miguel.model

import androidx.annotation.StringRes

data class Rent (
    val date: String,
    val rentDays: String,
    val price: Double,
    val vehicle: Vehicle,
    val user: User
)