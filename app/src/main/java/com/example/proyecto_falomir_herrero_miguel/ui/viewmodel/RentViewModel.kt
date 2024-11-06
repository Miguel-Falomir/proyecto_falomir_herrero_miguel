package com.example.proyecto_falomir_herrero_miguel.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.proyecto_falomir_herrero_miguel.data.Data
import com.example.proyecto_falomir_herrero_miguel.model.RentUIState

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

private val i = 0

class RentViewModel : ViewModel() {
    // variable privada, para guardar datos
    private val _uiState = MutableStateFlow(
        RentUIState(
            date = Data().RentList()[i].date,
            rentDays = Data().RentList()[i].rentDays,
            price = Data().RentList()[i].price,
            vehicleUIState = Data().RentList()[i].vehicleUIState,
            userUIState = Data().RentList()[i].userUIState
        )
    )
    // copia de la variable privada, para modificar copia de los datos.
    val uiState: StateFlow<RentUIState> = _uiState.asStateFlow()

    // INSERTAR FUNCIONES //

}