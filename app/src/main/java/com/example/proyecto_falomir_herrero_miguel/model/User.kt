package com.example.proyecto_falomir_herrero_miguel.model

import androidx.annotation.DrawableRes
import com.example.proyecto_falomir_herrero_miguel.R

data class User(
    val name: String = "",
    val surnames: String = "",
    val email: String = "",
    val phone: String = "",
    @DrawableRes val profileImageId: Int = R.drawable.profile_image,
    val paycard: Paycard = Paycard()
)