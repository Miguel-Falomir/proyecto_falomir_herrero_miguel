package com.example.proyecto_falomir_herrero_miguel.model

import androidx.annotation.DrawableRes

data class User(
    val name:String,
    val surnames: String,
    val email: String,
    val phone: String,
    @DrawableRes val profileImageId: Int,
    val paycard: Paycard
)