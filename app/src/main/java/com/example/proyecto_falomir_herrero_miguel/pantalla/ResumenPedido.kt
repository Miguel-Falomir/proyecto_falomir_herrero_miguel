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
import com.example.proyecto_falomir_herrero_miguel.model.BikeUIState
import com.example.proyecto_falomir_herrero_miguel.model.CarUIState
import com.example.proyecto_falomir_herrero_miguel.model.RentUIState

// METODO INICIAR PANTALLA ------------------------------------------

@Composable
fun PantallaResumenPedido(
    onAcceptButton: () -> Unit,
    onCancelButton: () -> Unit,
    modifier: Modifier = Modifier
){
    ResumenPedido(
        onAcceptButton,
        onCancelButton,
        modifier = modifier
    )
}

// M -

@Composable
fun ResumenPedido(
    onAcceptButton: () -> Unit,
    onCancelButton: () -> Unit,
    modifier: Modifier = Modifier
){
    // variables internas //
    val rentUIState: RentUIState = Data().RentList()[1]
    // estructura general //
    Column (
        modifier = modifier.fillMaxWidth()
    ){
        // tipo vehiculo //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPedido_Vehicle),
            dato = rentUIState.vehicleUIState.brand + " " + rentUIState.vehicleUIState.model,
            modifier = Modifier.padding(20.dp)
        )
        // nombre vehiculo //
        FilaDatoAuxiliar(
            texto = stringResource(R.string.blankSpace),
            dato = when (rentUIState.vehicleUIState) {
                is CarUIState -> stringResource(R.string.vehicle_type1)
                is BikeUIState -> stringResource(R.string.vehicle_type2)
                else -> stringResource(R.string.vehicle_type3)
            },
            modifier = Modifier.padding(20.dp)
        )
        // atributo concreto de cada vehiculo //
        when (rentUIState.vehicleUIState) {
            is CarUIState ->
                FilaSalidaDato(
                    texto = stringResource(R.string.ResumenPedido_Fuel),
                    dato = rentUIState.vehicleUIState.fuel,
                    modifier = Modifier.padding(20.dp)
                )
            is BikeUIState ->
                FilaSalidaDato(
                    texto = stringResource(R.string.ResumenPedido_Size),
                    dato = rentUIState.vehicleUIState.size,
                    modifier = Modifier.padding(20.dp)
                )
            else -> null
        }
        // GPS //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPedido_HasGPS),
            dato = rentUIState.vehicleUIState.hasGPS.toString(),
            modifier = Modifier.padding(20.dp)
        )
        // fecha //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPedido_Date),
            dato = rentUIState.date,
            modifier = Modifier.padding(20.dp)
        )
        // alquiler //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPedido_RentDays),
            dato = rentUIState.rentDays + " " + stringResource(R.string.ResumenPedido_Time),
            modifier = Modifier.padding(20.dp)
        )
        // total //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPedido_Total),
            dato = rentUIState.price.toString() + " " + stringResource(R.string.ResumenPedido_Coin),
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
fun ResumenPedidoPreview() {
    AppTheme {
        PantallaResumenPedido(
            onCancelButton = {},
            onAcceptButton = {}
        )
    }
}