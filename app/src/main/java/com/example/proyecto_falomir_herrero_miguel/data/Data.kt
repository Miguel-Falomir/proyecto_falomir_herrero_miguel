package com.example.proyecto_falomir_herrero_miguel.data

import com.example.proyecto_falomir_herrero_miguel.R
import com.example.proyecto_falomir_herrero_miguel.model.BikeUIState
import com.example.proyecto_falomir_herrero_miguel.model.CarUIState
import com.example.proyecto_falomir_herrero_miguel.model.PaycardUIState
import com.example.proyecto_falomir_herrero_miguel.model.RentUIState
import com.example.proyecto_falomir_herrero_miguel.model.ScooterUIState
import com.example.proyecto_falomir_herrero_miguel.model.UserUIState
import com.example.proyecto_falomir_herrero_miguel.model.VehicleUIState

class Data {
    // tarjetas bancarias
    fun CreditCardTypes(): List<String> = listOf(
        "Visa",
        "Master Card",
        "Euro 6000"
    )
    fun VisaCard(): PaycardUIState = PaycardUIState(
        type = CreditCardTypes()[0],
        number = "1234-5678-1357-2468",
        date = "01/2027",
        code = "555"
    )
    // usuarios
    fun UserDemo(): UserUIState = UserUIState(
        name = "Suzanne",
        surnames = "Garrido Nemesio",
        email = "suzieGN@email.blend",
        phone = "(+34) 555 123 456",
        profileImageId = R.drawable.profile_image,
        paycardUIState = VisaCard()
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
    fun VehicleList(): List<VehicleUIState> = listOf(
        CarUIState(
            brand = CarModels()[0][0],
            model = CarModels()[0][1],
            hasGPS = false,
            fuel = CarFuels()[0]
        ),
        BikeUIState(
            brand = BikeModels()[0][0],
            model = BikeModels()[0][1],
            hasGPS = false,
            size = BikeSizes()[0]
        ),
        ScooterUIState(
            brand = ScooterModels()[0][0],
            model = ScooterModels()[0][1],
            hasGPS = false
        )
    )
    // registro alquileres
    fun RentList(): List<RentUIState> = listOf(
        RentUIState(
            "2024-10-03",
            "2",
            100.00,
            VehicleList()[0],
            UserDemo()
        ),
        RentUIState(
            "2024-10-03",
            "2",
            100.00,
            VehicleList()[1],
            UserDemo()
        ),
        RentUIState(
            "2024-10-03",
            "2",
            100.00,
            VehicleList()[2],
            UserDemo()
        ),
        RentUIState(
            "2024-10-03",
            "2",
            100.00,
            VehicleList()[2],
            UserDemo()
        ),
        RentUIState(
            "2024-11-01",
            "2",
            100.00,
            VehicleList()[1],
            UserDemo()
        ),
        RentUIState(
            "2024-10-03",
            "2",
            100.00,
            VehicleList()[2],
            UserDemo()
        ),
        RentUIState(
            "2024-10-03",
            "2",
            100.00,
            VehicleList()[0],
            UserDemo()
        ),
        RentUIState(
            "2024-10-03",
            "2",
            100.00,
            VehicleList()[0],
            UserDemo()
        ),
        RentUIState(
            "2024-10-03",
            "2",
            100.00,
            VehicleList()[2],
            UserDemo()
        )
    )
}