package com.example.proyecto_falomir_herrero_miguel.data

import com.example.proyecto_falomir_herrero_miguel.R
import com.example.proyecto_falomir_herrero_miguel.model.Bike
import com.example.proyecto_falomir_herrero_miguel.model.Car
import com.example.proyecto_falomir_herrero_miguel.model.Rent
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
    fun RentList(): List<Rent> = listOf(
        Rent(
            R.string.rent1_date,
            R.string.rent1_rentDays,
            R.string.rent1_price,
            VehicleList()[0],
            UserDemo()
        ),
        Rent(
            R.string.rent2_date,
            R.string.rent2_rentDays,
            R.string.rent2_price,
            VehicleList()[1],
            UserDemo()
        ),
        Rent(
            R.string.rent3_date,
            R.string.rent3_rentDays,
            R.string.rent3_price,
            VehicleList()[1],
            UserDemo()
        ),
        Rent(
            R.string.rent4_date,
            R.string.rent4_rentDays,
            R.string.rent4_price,
            VehicleList()[2],
            UserDemo()
        ),
        Rent(
            R.string.rent5_date,
            R.string.rent5_rentDays,
            R.string.rent5_price,
            VehicleList()[1],
            UserDemo()
        ),
        Rent(
            R.string.rent6_date,
            R.string.rent6_rentDays,
            R.string.rent6_price,
            VehicleList()[2],
            UserDemo()
        ),
        Rent(
            R.string.rent7_date,
            R.string.rent7_rentDays,
            R.string.rent7_price,
            VehicleList()[0],
            UserDemo()
        ),
        Rent(
            R.string.rent8_date,
            R.string.rent8_rentDays,
            R.string.rent8_price,
            VehicleList()[0],
            UserDemo()
        ),
        Rent(
            R.string.rent9_date,
            R.string.rent9_rentDays,
            R.string.rent9_price,
            VehicleList()[2],
            UserDemo()
        )
    )
}