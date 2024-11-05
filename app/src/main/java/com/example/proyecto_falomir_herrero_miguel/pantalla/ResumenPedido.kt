// PAQUETE ----------------------------------------------------------

package com.example.proyecto_falomir_herrero_miguel.pantalla

// LIBRERIAS --------------------------------------------------------

import androidx.compose.foundation.layout.Column
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
import com.example.proyecto_falomir_herrero_miguel.model.Scooter

// METODO INICIAR PANTALLA ------------------------------------------

@Composable
fun PantallaResumenPedido(modifier: Modifier = Modifier){
    ResumenPedido(modifier = modifier)
}

// M -

@Composable
fun ResumenPedido(
    modifier: Modifier = Modifier
){
    // variables internas //
    var rent: Rent = Data().RentList()[1]
    // estructura general //
    Column (
        modifier = modifier.fillMaxWidth()
    ){
        // tipo vehiculo //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPedido_Vehicle),
            dato = rent.vehicle.brand + " " + rent.vehicle.model,
            modifier = Modifier.padding(20.dp)
        )
        // nombre vehiculo //
        FilaDatoAuxiliar(
            texto = stringResource(R.string.blankSpace),
            dato = rent.vehicle.vehicle,
            modifier = Modifier.padding(20.dp)
        )
        // atributo concreto de cada vehiculo //
        when (rent.vehicle) {
            is Car ->
                FilaSalidaDato(
                    texto = stringResource(R.string.ResumenPedido_Fuel),
                    dato = (rent.vehicle as Car).fuel,
                    modifier = Modifier.padding(20.dp)
                )
            is Bike ->
                FilaSalidaDato(
                    texto = stringResource(R.string.ResumenPedido_Size),
                    dato = (rent.vehicle as Bike).size,
                    modifier = Modifier.padding(20.dp)
                )
            else -> null
        }
        // GPS //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPedido_HasGPS),
            dato = rent.vehicle.hasGPS.toString(),
            modifier = Modifier.padding(20.dp)
        )
        // fecha //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPedido_Date),
            dato = rent.date,
            modifier = Modifier.padding(20.dp)
        )
        // alquiler //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPedido_RentDays),
            dato = rent.rentDays,
            modifier = Modifier.padding(20.dp)
        )
        // total //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPedido_Total),
            dato = rent.price.toString() + " " + stringResource(R.string.ResumenPedido_Coin),
            modifier = Modifier.padding(20.dp)
        )
        // espaciar //
        Spacer(modifier = Modifier.weight(1F))
        // botones aceptar y cancelar //
        FilaBotones(
            list = listOf(
                R.string.button_cancel,
                R.string.button_accept
            ),
            modifier = Modifier
        )
    }
}

// PREVIEW ----------------------------------------------------------

@Preview(showBackground = true)
@Composable
fun ResumenPedidoPreview() {
    AppTheme {
        PantallaResumenPedido()
    }
}