package com.example.proyecto_falomir_herrero_miguel.data

import com.example.proyecto_falomir_herrero_miguel.R
import com.example.proyecto_falomir_herrero_miguel.model.Bike
import com.example.proyecto_falomir_herrero_miguel.model.Car
import com.example.proyecto_falomir_herrero_miguel.model.Paycard
import com.example.proyecto_falomir_herrero_miguel.model.Rent
import com.example.proyecto_falomir_herrero_miguel.model.Scooter
import com.example.proyecto_falomir_herrero_miguel.model.User
import com.example.proyecto_falomir_herrero_miguel.model.Vehicle

class Data {
    fun VisaCard(): Paycard = Paycard(
        type = R.string.visa1_Type.toString(),
        number = R.string.visa1_Number.toString(),
        date = R.string.visa1_Date.toString(),
        code = R.string.visa1_Code.toString()
    )
    fun UserDemo(): User = User(
        name = R.string.User_name.toString(),
        surnames = R.string.User_surnames.toString(),
        email = R.string.User_email.toString(),
        phone = R.string.User_phone.toString(),
        profileImageId = R.drawable.profile_image,
        paycard = VisaCard()
    )
    fun VehicleList(): List<Vehicle> = listOf(
        Car(
            R.string.vehicle_type1.toString(),
            R.string.car1_brand.toString(),
            R.string.car1_model.toString(),
            false,
            R.string.vehicle_fuel1.toString()
        ),
        Bike(
            R.string.vehicle_type2.toString(),
            R.string.bike1_brand.toString(),
            R.string.bike1_model.toString(),
            false,
            R.string.vehicle_size1.toString()
        ),
        Scooter(
            R.string.vehicle_type3.toString(),
            R.string.scooter1_brand.toString(),
            R.string.scooter1_model.toString(),
            false
        )
    )
    fun RentList(): List<Rent> = listOf(
        Rent(
            R.string.rent1_date.toString(),
            R.string.rent1_rentDays.toString(),
            R.string.rent1_price.toDouble(),
            VehicleList()[0],
            UserDemo()
        ),
        Rent(
            R.string.rent2_date.toString(),
            R.string.rent2_rentDays.toString(),
            R.string.rent2_price.toDouble(),
            VehicleList()[1],
            UserDemo()
        ),
        Rent(
            R.string.rent3_date.toString(),
            R.string.rent3_rentDays.toString(),
            R.string.rent3_price.toDouble(),
            VehicleList()[2],
            UserDemo()
        ),
        Rent(
            R.string.rent4_date.toString(),
            R.string.rent4_rentDays.toString(),
            R.string.rent4_price.toDouble(),
            VehicleList()[2],
            UserDemo()
        ),
        Rent(
            R.string.rent5_date.toString(),
            R.string.rent5_rentDays.toString(),
            R.string.rent5_price.toDouble(),
            VehicleList()[1],
            UserDemo()
        ),
        Rent(
            R.string.rent6_date.toString(),
            R.string.rent6_rentDays.toString(),
            R.string.rent6_price.toDouble(),
            VehicleList()[2],
            UserDemo()
        ),
        Rent(
            R.string.rent7_date.toString(),
            R.string.rent7_rentDays.toString(),
            R.string.rent7_price.toDouble(),
            VehicleList()[0],
            UserDemo()
        ),
        Rent(
            R.string.rent8_date.toString(),
            R.string.rent8_rentDays.toString(),
            R.string.rent8_price.toDouble(),
            VehicleList()[0],
            UserDemo()
        ),
        Rent(
            R.string.rent9_date.toString(),
            R.string.rent9_rentDays.toString(),
            R.string.rent9_price.toDouble(),
            VehicleList()[2],
            UserDemo()
        )
    )
}