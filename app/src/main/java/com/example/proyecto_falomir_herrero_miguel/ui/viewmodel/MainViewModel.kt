package com.example.proyecto_falomir_herrero_miguel.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.proyecto_falomir_herrero_miguel.model.Bike
import com.example.proyecto_falomir_herrero_miguel.model.Car
import com.example.proyecto_falomir_herrero_miguel.model.Paycard
import com.example.proyecto_falomir_herrero_miguel.model.Rent
import com.example.proyecto_falomir_herrero_miguel.model.RentUIState
import com.example.proyecto_falomir_herrero_miguel.model.Scooter
import com.example.proyecto_falomir_herrero_miguel.model.Vehicle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel: ViewModel() {
    // variable 'Rent' para guardar datos
    private val _RentUIState = MutableStateFlow(RentUIState())
    // copia variable para mostrar datos
    val rentUIState: StateFlow<RentUIState> = _RentUIState.asStateFlow()

    // variables //

    var uiVehicleType by mutableStateOf("")
        private set

    var uiVehicleBrand by mutableStateOf("")
        private set

    var uiVehicleModel by mutableStateOf("")
        private set

    var uiVehicleGPS by mutableStateOf(false)
        private set

    var uiVehicleFuel by mutableStateOf("")
        private set

    var uiVehicleSize by mutableStateOf("")
        private set

    var uiRentDate by mutableStateOf("")
        private set

    var uiRentDays by mutableStateOf("")
        private set

    var uiPaycardType by mutableStateOf("")
        private set

    var uiPaycardNumber by mutableStateOf("")
        private set

    var uiPaycardExpiration by mutableStateOf("")
        private set

    var uiPaycardCode by mutableStateOf("")
        private set

    // metodos //

    fun insertVehicleType(input: String){
        uiVehicleType = input
        /*
        when (uiVehicleType) {
            "0" -> _RentUIState.update { estadoActual ->
                estadoActual.copy(
                    alquiler = Rent(
                        vehicle = Car()
                    )
                )
            }
            "1" -> _RentUIState.update { estadoActual ->
                estadoActual.copy(
                    alquiler = Rent(
                        vehicle = Bike()
                    )
                )
            }
            else -> _RentUIState.update { estadoActual ->
                estadoActual.copy(
                    alquiler = Rent(
                        vehicle = Scooter()
                    )
                )
            }
        }
         */
    }

    fun insertVehicleBrand(input: String){
        uiVehicleBrand = input
        /*
        when (uiVehicleType) {
            "0" -> _RentUIState.update { estadoActual ->
                estadoActual.copy(
                    alquiler = Rent(
                        vehicle = Car(brand = uiVehicleBrand)
                    )
                )
            }
            "1" -> _RentUIState.update { estadoActual ->
                estadoActual.copy(
                    alquiler = Rent(
                        vehicle = Bike(brand = uiVehicleBrand)
                    )
                )
            }
            else -> _RentUIState.update { estadoActual ->
                estadoActual.copy(
                    alquiler = Rent(
                        vehicle = Scooter(brand = uiVehicleBrand)
                    )
                )
            }
        }
         */
    }

    fun insertVehicleModel(input: String){
        uiVehicleModel = input
        /*
        when (uiVehicleType) {
        "0" -> _RentUIState.update { estadoActual ->
                estadoActual.copy(
                    alquiler = Rent(
                        vehicle = Car(model = uiVehicleModel)
                    )
                )
            }
        "1" -> _RentUIState.update { estadoActual ->
                estadoActual.copy(
                    alquiler = Rent(
                        vehicle = Bike(model = uiVehicleModel)
                    )
                )
            }
        else -> _RentUIState.update { estadoActual ->
                estadoActual.copy(
                    alquiler = Rent(
                        vehicle = Scooter(model = uiVehicleModel)
                    )
                )
            }
        }
         */
    }

    fun insertVehicleGPS(input: Boolean){
        uiVehicleGPS= input
        /*
        when (uiVehicleType) {
            "0" -> _RentUIState.update { estadoActual ->
                estadoActual.copy(
                    alquiler = Rent(
                        vehicle = Car(hasGPS = uiVehicleGPS)
                    )
                )
            }
            "1" -> _RentUIState.update { estadoActual ->
                estadoActual.copy(
                    alquiler = Rent(
                        vehicle = Bike(hasGPS = uiVehicleGPS)
                    )
                )
            }
            else -> _RentUIState.update { estadoActual ->
                estadoActual.copy(
                    alquiler = Rent(
                        vehicle = Scooter(hasGPS = uiVehicleGPS)
                    )
                )
            }
        }
         */
    }

    fun insertVehicleFuel(input: String){
        uiVehicleFuel = input
        /*
        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                alquiler = Rent(
                    vehicle = Car(fuel = uiVehicleFuel)
                )
            )
        }
         */
    }

    fun insertVehicleSize(input: String){
        uiVehicleSize = input
        /*
        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                alquiler = Rent(
                    vehicle = Bike(size = uiVehicleSize)
                )
            )
        }
         */
    }

    fun insertRentDate(input: String){
        uiRentDate = input
        /*
        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                alquiler = Rent(
                    date = uiRentDate
                )
            )
        }
         */
    }

    fun insertRentDays(input: String){
        uiRentDays = input
        /*
        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                alquiler = Rent(
                    rentDays = uiRentDays.toInt()
                )
            )
        }
         */
    }

    fun insertPaycardType(input: String){
        uiPaycardType = input
        /*
        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                alquiler = Rent(
                    user = User(
                        paycard = Paycard(
                            type = uiPaycardType
                        )
                    )
                )
            )
        }
         */
    }

    fun insertPaycardNumber(input: String){
        uiPaycardNumber = input
        /*
        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                alquiler = Rent(
                    user = User(
                        paycard = Paycard(
                            number = uiPaycardNumber
                        )
                    )
                )
            )
        }
         */
    }

    fun insertPaycardExpiration(input: String){
        uiPaycardExpiration = input
        /*
        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                alquiler = Rent(
                    user = User(
                        paycard = Paycard(
                            date = uiPaycardExpiration
                        )
                    )
                )
            )
        }
         */
    }

    fun insertPaycardCode(input: String){
        uiPaycardCode = input
        /*
        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                alquiler = Rent(
                    user = User(
                        paycard = Paycard(
                            code = uiPaycardCode
                        )
                    )
                )
            )
        }
         */
    }

    fun updatePrice() : Double{
        var rentPrice: Double = 0.0

        when (uiVehicleType) {
            "0" -> rentPrice = when (uiVehicleFuel) {
                "0" -> 25.0
                "1" -> 20.0
                "2" -> 15.0
                else -> 0.0
            }
            "1" -> rentPrice = when (uiVehicleSize) {
                "0" -> 15.0
                "1" -> 20.0
                "2" -> 25.0
                else -> 0.0
            }
            else -> rentPrice = 5.0
        }

        if(uiVehicleGPS){ rentPrice += 5.0 } else{}

        rentPrice *= uiRentDays.toInt()

        return rentPrice
    }

    fun updateRent(){
        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                alquiler = Rent(
                    vehicle = when (uiVehicleType) {
                        "0" -> Car(
                            brand = uiVehicleBrand,
                            model = uiVehicleModel,
                            hasGPS = uiVehicleGPS,
                            fuel = uiVehicleFuel
                        )
                        "1" -> Bike(
                            brand = uiVehicleBrand,
                            model = uiVehicleModel,
                            hasGPS = uiVehicleGPS,
                            size = uiVehicleSize
                        )
                        "2" -> Scooter(
                            brand = uiVehicleBrand,
                            model = uiVehicleModel,
                            hasGPS = uiVehicleGPS
                        )
                        else -> Vehicle(
                            brand = uiVehicleBrand,
                            model = uiVehicleModel,
                            hasGPS = uiVehicleGPS
                        )
                    },
                    date = uiRentDate,
                    rentDays = uiRentDays.toInt(),
                    price = updatePrice(),
                    paycard = Paycard(
                        type = uiPaycardType,
                        date = uiPaycardExpiration,
                        number = uiPaycardNumber,
                        code = uiPaycardCode
                    )
                )
            )
        }
    }
}