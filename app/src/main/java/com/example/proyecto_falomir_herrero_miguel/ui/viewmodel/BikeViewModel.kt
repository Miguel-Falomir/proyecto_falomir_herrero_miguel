package com.example.proyecto_falomir_herrero_miguel.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.proyecto_falomir_herrero_miguel.data.Data
import com.example.proyecto_falomir_herrero_miguel.model.BikeUIState

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

private val i = 1

class BikeViewModel : ViewModel() {
    // variable privada, para guardar datos
    private val _uiState = MutableStateFlow(
        BikeUIState(
            vehicle = (Data().VehicleList()[i] as BikeUIState).vehicle,
            brand = (Data().VehicleList()[i] as BikeUIState).brand,
            model = (Data().VehicleList()[i] as BikeUIState).model,
            hasGPS = (Data().VehicleList()[i] as BikeUIState).hasGPS,
            size = (Data().VehicleList()[i] as BikeUIState).size,
        )
    )
    // copia de la variable privada, para modificar copia de los datos.
    val uiState: StateFlow<BikeUIState> = _uiState.asStateFlow()

    // CREO QUE ESTA CLASE NO SE VA A UTILIZAR //

}