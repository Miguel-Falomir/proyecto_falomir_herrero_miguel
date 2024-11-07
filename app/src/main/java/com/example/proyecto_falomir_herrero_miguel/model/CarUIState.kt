package com.example.proyecto_falomir_herrero_miguel.model

data class CarUIState(
    override val brand: String,
    override val model: String,
    override val hasGPS: Boolean,
    val fuel: String

) : VehicleUIState(brand, model, hasGPS) {
    /**
     * LO HAS HECHO TOODO AL REVES
     * LA LOGICA , Y FUNCIONES, SE GENERA EN 'ClaseViewModel'
     * NO EN 'ClaseUIState', QUE SOLO SE USA PARA DEFINIR EL CONSTRUCTOR.
     * ASI QUE YA ESTAS TARDANDO EN CAMBIAR LOS CORCHETES >:(
     * [SONIDO DE REBUSCAR SANDALIAS EN EL ZAPATERO DE MADRE]
     */
}