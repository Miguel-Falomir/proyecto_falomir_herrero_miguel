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

// METODO INICIAR PANTALLA ------------------------------------------

@Composable
fun PantallaResumenPedido(
    onAcceptButton: () -> Unit,
    onCancelButton: () -> Unit,
    rentState: RentUIState,
    modifier: Modifier = Modifier
){
    ResumenPedido(
        onAcceptButton,
        onCancelButton,
        rentState = rentState,
        modifier = modifier
    )
}

// M -

@Composable
fun ResumenPedido(
    onAcceptButton: () -> Unit,
    onCancelButton: () -> Unit,
    rentState: RentUIState,
    modifier: Modifier = Modifier
){
    // estructura general //
    Column (
        modifier = modifier.fillMaxWidth()
    ){
        // nombre vehiculo //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPedido_Vehicle),
            dato = rentState.vehicleBrand + " " + rentState.vehicleModel,
            modifier = Modifier.padding(20.dp)
        )
        // tipo vehiculo //
        FilaDatoAuxiliar(
            texto = stringResource(R.string.blankSpace),
            dato = when (rentState.vehicleType){
                "0" -> stringResource(R.string.vehicle_type1)
                "1" -> stringResource(R.string.vehicle_type2)
                else -> stringResource(R.string.vehicle_type3)
            },
            modifier = Modifier.padding(20.dp)
        )
        // atributo concreto de cada vehiculo //
        when (rentState.vehicleType) {
            "0" ->
                FilaSalidaDato(
                    texto = stringResource(R.string.ResumenPedido_Fuel),
                    dato = when (rentState.vehicleFuel) {
                        "0" -> stringResource(R.string.vehicle_fuel1)
                        "1" -> stringResource(R.string.vehicle_fuel2)
                        else -> stringResource(R.string.vehicle_fuel3)
                    },
                    modifier = Modifier.padding(20.dp)
                )
            "1" ->
                FilaSalidaDato(
                    texto = stringResource(R.string.ResumenPedido_Size),
                    dato = rentState.vehicleSize,
                    modifier = Modifier.padding(20.dp)
                )
            else -> null
        }
        // GPS //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPedido_HasGPS),
            dato = when (rentState.vehicleGPS){
                true -> stringResource(R.string.Check_Y)
                else -> stringResource(R.string.Check_N)
            },
            modifier = Modifier.padding(20.dp)
        )
        // fecha //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPedido_Date),
            dato = rentState.rentDate,
            modifier = Modifier.padding(20.dp)
        )
        // alquiler //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPedido_RentDays),
            dato = rentState.rentDays + " " + stringResource(R.string.ResumenPedido_Time),
            modifier = Modifier.padding(20.dp)
        )
        // total //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPedido_Total),
            dato = rentState.rentPrice + " " + stringResource(R.string.ResumenPedido_Coin),
            modifier = Modifier.padding(20.dp)
        )
        // espaciar //
        Spacer(modifier = Modifier.weight(1F))
        // botones aceptar y cancelar //
        Row (
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
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
            onAcceptButton = {},
            rentState = RentUIState(
                vehicleType = "0",
                vehicleBrand = "Seat",
                vehicleModel = "Ibiza",
                vehicleGPS = true,
                vehicleFuel = "0",
                rentDate = "2024-10-10",
                rentDays = "2",
                rentPrice = "100.00"
            )
        )
    }
}