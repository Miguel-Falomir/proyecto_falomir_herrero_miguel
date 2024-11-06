package com.example.proyecto_falomir_herrero_miguel.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.proyecto_falomir_herrero_miguel.data.Data
import com.example.proyecto_falomir_herrero_miguel.model.VehicleUIState

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

private val i = 1

class VehicleViewModel : ViewModel() {
    // variable privada, para guardar datos
    private val _uiState = MutableStateFlow(
        VehicleUIState(
            vehicle =  Data().VehicleTypes()[0],
            brand =  Data().CarModels()[i][0],
            model =  Data().CarModels()[i][1],
            hasGPS = false
        )
    )
    // copia de la variable privada, para modificar copia de los datos.
    val uiState: StateFlow<VehicleUIState> = _uiState.asStateFlow()

    // INSERTAR FUNCIONES //

}