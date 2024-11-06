package com.example.proyecto_falomir_herrero_miguel.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.proyecto_falomir_herrero_miguel.data.Data
import com.example.proyecto_falomir_herrero_miguel.model.UserUIState

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

//private val i = 0

class UserViewModel : ViewModel() {
    // variable privada, para guardar datos
    private val _uiState = MutableStateFlow(
        UserUIState(
            name = Data().UserDemo().name,
            surnames = Data().UserDemo().surnames,
            email = Data().UserDemo().email,
            phone = Data().UserDemo().phone,
            profileImageId = Data().UserDemo().profileImageId,
            paycardUIState = Data().UserDemo().paycardUIState
        )
    )
    // copia de la variable privada, para modificar copia de los datos.
    val uiState: StateFlow<UserUIState> = _uiState.asStateFlow()

    // CREO QUE ESTA CLASE NO SE VA A UTILIZAR //

}