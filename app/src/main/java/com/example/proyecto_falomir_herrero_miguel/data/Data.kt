package com.example.proyecto_falomir_herrero_miguel.data

import com.example.proyecto_falomir_herrero_miguel.R
import com.example.proyecto_falomir_herrero_miguel.model.User

class Data {
    fun UserDemo(): User = User(
        nameId = R.string.User_name,
        surnamesId = R.string.User_surnames,
        emailId = R.string.User_email,
        phoneNumberId = R.string.User_phone,
        profileImageId = R.drawable.profile_image
    )
}