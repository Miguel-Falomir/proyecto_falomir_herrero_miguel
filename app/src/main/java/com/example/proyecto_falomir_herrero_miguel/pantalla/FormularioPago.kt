// PAQUETE ----------------------------------------------------------

package com.example.proyecto_falomir_herrero_miguel.pantalla

// LIBRERIAS --------------------------------------------------------

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme
import com.example.proyecto_falomir_herrero_miguel.R
import com.example.proyecto_falomir_herrero_miguel.data.Data
import com.example.proyecto_falomir_herrero_miguel.model.Paycard
import com.example.proyecto_falomir_herrero_miguel.ui.theme.One

// METODO INICIAR PANTALLA ------------------------------------------

@Composable
fun PantallaFormularioPago(modifier: Modifier = Modifier){
    FormularioPago(modifier = modifier)
}

// METODO RESUMEN PEDIDO --------------------------------------------

@Composable
fun FormularioPago(modifier: Modifier = Modifier){
    // variables internas //
    var tipoTarjeta by remember { mutableStateOf(0) }
    var numeroTarjeta by remember { mutableStateOf("") }
    var fechaTarjeta by remember { mutableStateOf("") }
    var codigoTarjeta by remember { mutableStateOf("") }
    // estructura general //
    Column (
        modifier = modifier.fillMaxWidth()
    ){
        // tipo tarjeta //
        Text(
            modifier = Modifier.padding(20.dp).fillMaxWidth(),
            text = stringResource(R.string.FormularioPago_CreditType),
            fontFamily = One
        )
        Row (
            modifier = Modifier.padding(20.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Boton(
                w = 100, h = 60,
                onClick = { tipoTarjeta = 0 },
                texto = R.string.creditCard_type1
            )
            Boton(
                w = 100, h = 60,
                onClick = { tipoTarjeta = 1 },
                texto = R.string.creditCard_type2
            )
            Boton(
                w = 100, h = 60,
                onClick = { tipoTarjeta = 2 },
                texto = R.string.creditCard_type3
            )
        }
        // datos tarjeta //
        EntradaTexto(
            value = numeroTarjeta,
            onValueChange = { it -> numeroTarjeta = it },
            texto = R.string.FormularioPago_CreditNumber,
            modifier = Modifier.padding(20.dp)
        )
        EntradaTexto(
            value = fechaTarjeta,
            onValueChange = { it -> fechaTarjeta = it },
            texto = R.string.FormularioPago_CreditDate,
            modifier = Modifier.padding(20.dp)
        )
        EntradaTexto(
            value = codigoTarjeta,
            onValueChange = { it -> codigoTarjeta = it },
            texto = R.string.FormularioPago_CreditCode,
            modifier = Modifier.padding(20.dp)
        )
        // espaciar //
        Spacer(modifier = Modifier.weight(1F))
        // botones //
        Row (
            modifier = Modifier.padding(20.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Boton(
                w = 160, h = 80,
                onClick = {  },
                texto = R.string.button_cancel
            )
            Boton(
                w = 160, h = 80,
                onClick = {  },
                texto = R.string.button_pay
            )
        }
    }

}

// PREVIEW ----------------------------------------------------------

@Preview(showBackground = true)
@Composable
fun FormularioPagoPreview() {
    AppTheme {
        PantallaFormularioPago()
    }
}