package com.example.proyecto_falomir_herrero_miguel.model

data class RentUIState(
    // vehiculo //
    val vehicleType: String = "",
    val vehicleBrand: String = "",
    val vehicleModel: String = "",
    val vehicleGPS: Boolean = false,
    val vehicleFuel: String = "",
    val vehicleSize: String = "",
    // alquiler //
    val rentDate: String = "",
    val rentDays: String = "",
    val rentPrice: String = ""
)