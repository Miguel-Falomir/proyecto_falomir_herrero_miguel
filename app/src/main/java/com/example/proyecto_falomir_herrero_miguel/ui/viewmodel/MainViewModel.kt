package com.example.proyecto_falomir_herrero_miguel.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.proyecto_falomir_herrero_miguel.model.Paycard
import com.example.proyecto_falomir_herrero_miguel.model.RentUIState
import com.example.proyecto_falomir_herrero_miguel.model.Vehicle
import com.example.proyecto_falomir_herrero_miguel.model.Car
import com.example.proyecto_falomir_herrero_miguel.model.Bike
import com.example.proyecto_falomir_herrero_miguel.model.Rent
import com.example.proyecto_falomir_herrero_miguel.model.Scooter
import com.example.proyecto_falomir_herrero_miguel.model.User
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

    var uiRentPrice by mutableStateOf("")
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

    fun updateVehicleType(input: String){
        uiVehicleType = input

        /*
        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                // pendiente //
            )
        }
         */
    }

    fun updateVehicleBrand(input: String){
        uiVehicleBrand = input

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
    }

    fun updateVehicleModel(input: String){
        uiVehicleModel = input

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

    }

    fun updateVehicleGPS(input: Boolean){
        uiVehicleGPS= input

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
    }

    fun updateVehicleFuel(input: String){
        uiVehicleFuel = input

        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                alquiler = Rent(
                    vehicle = Car(fuel = uiVehicleFuel)
                )
            )
        }
    }

    fun updateVehicleSize(input: String){
        uiVehicleSize = input

        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                alquiler = Rent(
                    vehicle = Bike(size = uiVehicleSize)
                )
            )
        }
    }

    fun updateRentDate(input: String){
        uiRentDate = input

        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                alquiler = Rent(
                    date = uiRentDate
                )
            )
        }
    }

    fun updateRentDays(input: String){
        uiRentDays = input

        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                alquiler = Rent(
                    rentDays = uiRentDays.toInt()
                )
            )
        }
    }

    fun updateRentPrice(input: String){
        uiRentPrice = input

        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                alquiler = Rent(
                    price = uiRentPrice.toDouble()
                )
            )
        }
    }

    fun updatePaycardType(input: String){
        uiPaycardType = input

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
    }

    fun updatePaycardNumber(input: String){
        uiPaycardNumber = input

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
    }

    fun updatePaycardExpiration(input: String){
        uiPaycardExpiration = input

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
    }

    fun updatePaycardCode(input: String){
        uiPaycardCode = input

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
    }
}