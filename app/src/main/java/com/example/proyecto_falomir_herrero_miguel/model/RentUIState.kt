package com.example.proyecto_falomir_herrero_miguel.model

data class RentUIState (
    val date: String = "",
    val rentDays: String = "",
    val price: Double = 0.0,
    val vehicleUIState: VehicleUIState = CarUIState(),
    val userUIState: UserUIState = UserUIState()
)