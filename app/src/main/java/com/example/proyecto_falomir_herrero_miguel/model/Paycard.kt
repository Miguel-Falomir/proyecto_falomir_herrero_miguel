package com.example.proyecto_falomir_herrero_miguel.model

import androidx.annotation.StringRes

data class Paycard (
    val type: String,
    val number: String,
    val date: String,
    val code: String
)