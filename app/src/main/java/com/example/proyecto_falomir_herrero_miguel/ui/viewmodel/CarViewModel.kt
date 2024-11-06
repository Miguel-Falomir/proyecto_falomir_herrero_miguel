package com.example.proyecto_falomir_herrero_miguel.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.proyecto_falomir_herrero_miguel.data.Data
import com.example.proyecto_falomir_herrero_miguel.model.CarUIState

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

private val i = 0

class CarViewModel : ViewModel() {
    // variable privada, para guardar datos
    private val _uiState = MutableStateFlow(
        CarUIState(
            vehicle = (Data().VehicleList()[i] as CarUIState).vehicle,
            brand = (Data().VehicleList()[i] as CarUIState).brand,
            model = (Data().VehicleList()[i] as CarUIState).model,
            hasGPS = (Data().VehicleList()[i] as CarUIState).hasGPS,
            fuel = (Data().VehicleList()[i] as CarUIState).fuel,
        )
    )
    // copia de la variable privada, para modificar copia de los datos.
    val uiState: StateFlow<CarUIState> = _uiState.asStateFlow()

    // INSERTAR FUNCIONES //

}