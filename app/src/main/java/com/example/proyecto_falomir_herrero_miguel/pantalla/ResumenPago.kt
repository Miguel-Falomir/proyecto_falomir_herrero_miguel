// PAQUETE ----------------------------------------------------------

package com.example.proyecto_falomir_herrero_miguel.pantalla

// LIBRERIAS --------------------------------------------------------

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme
import com.example.proyecto_falomir_herrero_miguel.R
import com.example.proyecto_falomir_herrero_miguel.data.Data
import com.example.proyecto_falomir_herrero_miguel.model.Bike
import com.example.proyecto_falomir_herrero_miguel.model.Car
import com.example.proyecto_falomir_herrero_miguel.model.Rent
import com.example.proyecto_falomir_herrero_miguel.model.RentUIState
import com.example.proyecto_falomir_herrero_miguel.model.Scooter

// METODO INICIAR PANTALLA ------------------------------------------

@Composable
fun PantallaResumenPago(
    onCancelButton: () -> Unit,
    onAcceptButton: () -> Unit,
    rentState: RentUIState,
    modifier: Modifier = Modifier
){
    ResumenPago(
        onCancelButton,
        onAcceptButton,
        rentState = rentState,
        modifier = modifier
    )
}

// M -

@Composable
fun ResumenPago(
    onCancelButton: () -> Unit,
    onAcceptButton: () -> Unit,
    rentState: RentUIState,
    modifier: Modifier = Modifier
){
    // estructura general //
    Column (
        modifier = modifier.fillMaxWidth()
    ){
        // Ingreso //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPago_Income),
            dato = rentState.alquiler.price.toString() + " " + stringResource(R.string.ResumenPedido_Coin),
            modifier = Modifier.padding(20.dp)
        )
        // fecha //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPago_Date),
            dato = rentState.alquiler.date,
            modifier = Modifier.padding(20.dp)
        )
        // Concepto //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPago_Concept),
            dato = when (rentState.alquiler.vehicle) {
                is Car -> stringResource(R.string.vehicle_type1)
                is Bike -> stringResource(R.string.vehicle_type2)
                is Scooter -> stringResource(R.string.vehicle_type3)
                else -> stringResource(R.string.ClassError)
            } + " " + stringResource(R.string.ResumenPago_Rent),
            modifier = Modifier.padding(20.dp)
        )
        // Tarjeta //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPago_Card),
            // dato = rentState.alquiler.user.paycard.number,
            dato = rentState.alquiler.paycard.number,
            modifier = Modifier.padding(20.dp)
        )
        // Correo //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPago_Email),
            // dato = rentState.alquiler.user.email,
            dato = rentState.alquiler.user.email,
            modifier = Modifier.padding(20.dp)
        )
        // espaciar //
        Spacer(modifier = Modifier.weight(1F))
        // botones aceptar y cancelar //
        Row (
            modifier = Modifier.padding(20.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Boton(
                w = 160, h = 80,
                onClick = onCancelButton,
                texto = R.string.button_cancel
            )
            Boton(
                w = 160, h = 80,
                onClick = onAcceptButton,
                texto = R.string.button_accept
            )
        }
    }
}

// PREVIEW ----------------------------------------------------------

@Preview(showBackground = true)
@Composable
fun ResumenPagoPreview() {
    AppTheme {
        PantallaResumenPago(
            onCancelButton = {},
            onAcceptButton = {},
            rentState = RentUIState()
        )
    }
}