package com.example.proyecto_falomir_herrero_miguel.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.proyecto_falomir_herrero_miguel.data.Data
import com.example.proyecto_falomir_herrero_miguel.model.ScooterUIState

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

private val i = 2

class ScooterViewModel : ViewModel() {
    // variable privada, para guardar datos
    private val _uiState = MutableStateFlow(
        ScooterUIState(
            vehicle = (Data().VehicleList()[i] as ScooterUIState).vehicle,
            brand = (Data().VehicleList()[i] as ScooterUIState).brand,
            model = (Data().VehicleList()[i] as ScooterUIState).model,
            hasGPS = (Data().VehicleList()[i] as ScooterUIState).hasGPS
        )
    )
    // copia de la variable privada, para modificar copia de los datos.
    val uiState: StateFlow<ScooterUIState> = _uiState.asStateFlow()

    // INSERTAR FUNCIONES //

}