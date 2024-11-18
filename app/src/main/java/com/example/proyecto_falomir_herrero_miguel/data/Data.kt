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
    // tarjetas bancarias
    fun CreditCardTypes(): List<String> = listOf(
        "Visa",
        "Master Card",
        "Euro 6000"
    )
    fun VisaCard(): Paycard = Paycard(
        type = CreditCardTypes()[0],
        number = "1234-5678-1357-2468",
        date = "01/2027",
        code = "555"
    )
    // usuarios
    fun UserDemo(): User = User(
        name = "Suzanne",
        surnames = "Garrido Nemesio",
        email = "suzieGN@email.blend",
        phone = "(+34) 555 123 456",
        profileImageId = R.drawable.profile_image,
        paycard = VisaCard()
    )
    // combustibles coches
    fun CarFuels() : List<String> = listOf(
        "Gas",
        "Diesel",
        "Electric"
    )
    // cilindradas motos
    fun BikeSizes() : List<String> = listOf(
        "50 cc",
        "125 cc",
        "250 cc"
    )
    // modelos vehiculos
    fun CarModels(): List<List<String>> = listOf(
        listOf("Seat", "Ibiza")
    )
    fun BikeModels(): List<List<String>> = listOf(
        listOf("Vespa", "Vespino")
    )
    fun ScooterModels(): List<List<String>> = listOf(
        listOf("Cecotec", "Bongo")
    )
    // registro vehiculos
    fun VehicleList(): List<Vehicle> = listOf(
        Car(
            brand = CarModels()[0][0],
            model = CarModels()[0][1],
            hasGPS = false,
            fuel = CarFuels()[0]
        ),
        Bike(
            brand = BikeModels()[0][0],
            model = BikeModels()[0][1],
            hasGPS = false,
            size = BikeSizes()[0]
        ),
        Scooter(
            brand = ScooterModels()[0][0],
            model = ScooterModels()[0][1],
            hasGPS = false
        )
    )
    // registro alquileres
    fun RentList(): List<Rent> = listOf(
        Rent(
            "2024-10-03",
            2,
            100.00,
            VehicleList()[0],
            UserDemo()
        ),
        Rent(
            "2024-10-03",
            2,
            100.00,
            VehicleList()[1],
            UserDemo()
        ),
        Rent(
            "2024-10-03",
            2,
            100.00,
            VehicleList()[2],
            UserDemo()
        ),
        Rent(
            "2024-10-03",
            2,
            100.00,
            VehicleList()[2],
            UserDemo()
        ),
        Rent(
            "2024-11-01",
            2,
            100.00,
            VehicleList()[1],
            UserDemo()
        ),
        Rent(
            "2024-10-03",
            2,
            100.00,
            VehicleList()[2],
            UserDemo()
        ),
        Rent(
            "2024-10-03",
            2,
            100.00,
            VehicleList()[0],
            UserDemo()
        ),
        Rent(
            "2024-10-03",
            2,
            100.00,
            VehicleList()[0],
            UserDemo()
        ),
        Rent(
            "2024-10-03",
            2,
            100.00,
            VehicleList()[2],
            UserDemo()
        )
    )
}