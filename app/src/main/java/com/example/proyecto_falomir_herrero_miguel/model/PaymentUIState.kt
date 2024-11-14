package com.example.proyecto_falomir_herrero_miguel.model

data class PaymentUIState (
    // tarjeta //
    val paycardType: String = "",
    val paycardNumber: String = "",
    val paycardExpiration: String = "",
    val paycardCode: String = ""
)