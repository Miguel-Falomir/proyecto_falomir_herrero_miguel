package com.example.proyecto_falomir_herrero_miguel.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class User(
    @StringRes val nameId: Int,
    @StringRes val surnamesId: Int,
    @StringRes val emailId: Int,
    @StringRes val phoneNumberId: Int,
    @DrawableRes val profileImageId: Int,
    val paycard: Paycard
)