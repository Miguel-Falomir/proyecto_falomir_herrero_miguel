package com.example.proyecto_falomir_herrero_miguel.model

import androidx.annotation.DrawableRes

data class UserUIState(
    val name:String,
    val surnames: String,
    val email: String,
    val phone: String,
    @DrawableRes val profileImageId: Int,
    val paycardUIState: PaycardUIState
) {
    /**
     * LO HAS HECHO TOODO AL REVES
     * LA LOGICA , Y FUNCIONES, SE GENERA EN 'ClaseViewModel'
     * NO EN 'ClaseUIState', QUE SOLO SE USA PARA DEFINIR EL CONSTRUCTOR.
     * ASI QUE YA ESTAS TARDANDO EN CAMBIAR LOS CORCHETES >:(
     * [SONIDO DE REBUSCAR SANDALIAS EN EL ZAPATERO DE MADRE]
     */
}