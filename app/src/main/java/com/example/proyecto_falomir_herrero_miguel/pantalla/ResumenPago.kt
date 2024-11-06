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
import com.example.proyecto_falomir_herrero_miguel.model.RentUIState

// METODO INICIAR PANTALLA ------------------------------------------

@Composable
fun PantallaResumenPago(modifier: Modifier = Modifier){
    ResumenPago(modifier = modifier)
}

// M -

@Composable
fun ResumenPago(
    modifier: Modifier = Modifier
){
    // variables internas //
    var rentUIState: RentUIState = Data().RentList()[0]
    // estructura general //
    Column (
        modifier = modifier.fillMaxWidth()
    ){
        // Ingreso //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPago_Income),
            dato = rentUIState.price.toString() + " " + stringResource(R.string.ResumenPedido_Coin),
            modifier = Modifier.padding(20.dp)
        )
        // fecha //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPago_Date),
            dato = rentUIState.date,
            modifier = Modifier.padding(20.dp)
        )
        // Concepto //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPago_Concept),
            dato = rentUIState.vehicleUIState.vehicle + " " + stringResource(R.string.ResumenPago_Rent),
            modifier = Modifier.padding(20.dp)
        )
        // Tarjeta //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPago_Card),
            dato = rentUIState.userUIState.paycardUIState.number,
            modifier = Modifier.padding(20.dp)
        )
        // Correo //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPago_Email),
            dato = rentUIState.userUIState.email,
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
fun ResumenPagoPreview() {
    AppTheme {
        PantallaResumenPago()
    }
}