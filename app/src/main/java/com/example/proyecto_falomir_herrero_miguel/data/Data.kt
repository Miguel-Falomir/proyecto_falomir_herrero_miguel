package com.example.proyecto_falomir_herrero_miguel.data

import com.example.proyecto_falomir_herrero_miguel.R
import com.example.proyecto_falomir_herrero_miguel.model.Bike
import com.example.proyecto_falomir_herrero_miguel.model.Car
import com.example.proyecto_falomir_herrero_miguel.model.Scooter
import com.example.proyecto_falomir_herrero_miguel.model.User
import com.example.proyecto_falomir_herrero_miguel.model.Vehicle

class Data {
    fun UserDemo(): User = User(
        nameId = R.string.User_name,
        surnamesId = R.string.User_surnames,
        emailId = R.string.User_email,
        phoneNumberId = R.string.User_phone,
        profileImageId = R.drawable.profile_image
    )
    fun VehicleList(): List<Vehicle> = listOf(
        Car(
            R.string.car1_brand,
            R.string.car1_model,
            R.string.car1_hasGPS,
            R.string.car1_fuel
        ),
        Bike(
            R.string.bike1_brand,
            R.string.bike1_model,
            R.string.bike1_hasGPS,
            R.string.bike1_size
        ),
        Scooter(
            R.string.scooter1_brand,
            R.string.scooter1_model,
            R.string.scooter1_hasGPS
        )
    )
}