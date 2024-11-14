package com.example.proyecto_falomir_herrero_miguel.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.proyecto_falomir_herrero_miguel.model.PaymentUIState
import com.example.proyecto_falomir_herrero_miguel.model.RentUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel: ViewModel() {
    // variable 'Rent' para guardar datos
    private val _RentUIState = MutableStateFlow(RentUIState())
    // copia variable para mostrar datos
    val rentUIState: StateFlow<RentUIState> = _RentUIState.asStateFlow()

    // variable 'Payment' para guardar datos
    private val _PaymentUIState = MutableStateFlow(PaymentUIState())
    // copia variable para mostrar datos
    val paymentUIState: StateFlow<PaymentUIState> = _PaymentUIState.asStateFlow()

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

        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                vehicleType = uiVehicleType
            )
        }
    }

    fun updateVehicleBrand(input: String){
        uiVehicleBrand = input

        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                vehicleBrand = uiVehicleBrand
            )
        }
    }

    fun updateVehicleModel(input: String){
        uiVehicleModel = input

        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                vehicleModel = uiVehicleModel
            )
        }
    }

    fun updateVehicleGPS(input: Boolean){
        uiVehicleGPS= input

        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                vehicleGPS = uiVehicleGPS
            )
        }
    }

    fun updateVehicleFuel(input: String){
        uiVehicleFuel = input

        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                vehicleFuel = uiVehicleFuel
            )
        }
    }

    fun updateVehicleSize(input: String){
        uiVehicleSize = input

        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                vehicleBrand = uiVehicleSize
            )
        }
    }

    fun updateRentDate(input: String){
        uiRentDate = input

        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                rentDate = uiRentDate
            )
        }
    }

    fun updateRentDays(input: String){
        uiRentDays = input

        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                rentDays = uiRentDays
            )
        }
    }

    fun updateRentPrice(input: String){
        uiRentPrice = input

        _RentUIState.update { estadoActual ->
            estadoActual.copy(
                rentPrice = uiRentPrice
            )
        }
    }

    fun updatePaycardType(input: String){
        uiPaycardType = input

        _PaymentUIState.update { estadoActual ->
            estadoActual.copy(
                paycardType = uiPaycardType
            )
        }
    }

    fun updatePaycardNumber(input: String){
        uiPaycardNumber = input

        _PaymentUIState.update { estadoActual ->
            estadoActual.copy(
                paycardNumber = uiPaycardNumber
            )
        }
    }

    fun updatePaycardExpiration(input: String){
        uiPaycardExpiration = input

        _PaymentUIState.update { estadoActual ->
            estadoActual.copy(
                paycardExpiration = uiPaycardExpiration
            )
        }
    }

    fun updatePaycardCode(input: String){
        uiPaycardCode = input

        _PaymentUIState.update { estadoActual ->
            estadoActual.copy(
                paycardCode = uiPaycardCode
            )
        }
    }
}