// PAQUETE ----------------------------------------------------------

package com.example.proyecto_falomir_herrero_miguel.pantalla

// LIBRERIAS --------------------------------------------------------

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme
import com.example.proyecto_falomir_herrero_miguel.R
import com.example.proyecto_falomir_herrero_miguel.ui.theme.One

// METODO INICIAR PANTALLA ------------------------------------------

@Composable
fun PantallaRealizarPedido(modifier: Modifier = Modifier){
    RealizarPedido(modifier = modifier)
}

// METODO FORMULARIO PEDIDO -----------------------------------------

@Composable
fun RealizarPedido(modifier: Modifier = Modifier){
    // valores internos //
    val tipo1 = stringResource(R.string.vehicle_type1)
    val tipo2 = stringResource(R.string.vehicle_type2)
    val tipo3 = stringResource(R.string.vehicle_type3)
    val fuel1 = stringResource(R.string.vehicle_fuel1)
    val fuel2 = stringResource(R.string.vehicle_fuel2)
    val fuel3 = stringResource(R.string.vehicle_fuel3)
    val size1 = stringResource(R.string.vehicle_size1)
    val size2 = stringResource(R.string.vehicle_size2)
    val size3 = stringResource(R.string.vehicle_size3)
    // variables internas //
    var inputFecha by remember { mutableStateOf("1970-01-01") }
    var inputDias by remember { mutableStateOf("") }
    var inputTipo by remember { mutableStateOf(tipo1) }
    var inputMarca by remember { mutableStateOf("") }
    var inputModelo by remember { mutableStateOf("") }
    var inputFuel by remember { mutableStateOf("") }
    var inputSize by remember { mutableStateOf("") }
    var inputGPS by remember { mutableStateOf(false) }
    var precio by remember { mutableStateOf(0) }
    // extructura general //
    Column (
        modifier = modifier.fillMaxWidth()
    ){
        // tipo vehiculo //
        Text(
            modifier = Modifier.padding(20.dp, 20.dp, 20.dp, 0.dp).fillMaxWidth(),
            text = stringResource(R.string.ResumenPedido_Vehicle),
            fontFamily = One
        )
        Row (
            modifier = Modifier.padding(20.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Boton(
                w = 100, h = 40,
                onClick = { inputTipo = tipo1 },
                texto = R.string.vehicle_type1
            )
            Boton(
                w = 100, h = 40,
                onClick = { inputTipo = tipo2 },
                texto = R.string.vehicle_type2
            )
            Boton(
                w = 100, h = 40,
                onClick = { inputTipo = tipo3 },
                texto = R.string.vehicle_type3
            )
        }
        // marca //
        EntradaTexto(
            value = inputMarca,
            onValueChange = { inputMarca = it },
            texto = R.string.RealizarPedido_Brand,
            modifier = Modifier.padding(20.dp, 10.dp)
        )
        // modelo //
        EntradaTexto(
            value = inputModelo,
            onValueChange = { inputModelo = it },
            texto = R.string.RealizarPedido_Model,
            modifier = Modifier.padding(20.dp, 10.dp)
        )
        // atributo concreto (combustible, cilindrada o nada) //
        when (inputTipo) {
            tipo1 ->
                Text(
                    text = stringResource(R.string.ResumenPedido_Fuel),
                    fontFamily = One,
                    modifier = Modifier.padding(20.dp)
                )
            tipo2 ->
                Text(
                    text = stringResource(R.string.ResumenPedido_Size),
                    fontFamily = One,
                    modifier = Modifier.padding(20.dp)
                )
            else -> null
        }
        when (inputTipo) {
            tipo1 ->
                Row (
                    modifier = Modifier.padding(20.dp, 10.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Boton(
                        w = 100, h = 40,
                        onClick = { inputFuel = fuel1 },
                        texto = R.string.vehicle_fuel1
                    )
                    Boton(
                        w = 100, h = 40,
                        onClick = { inputFuel = fuel2 },
                        texto = R.string.vehicle_fuel2
                    )
                    Boton(
                        w = 100, h = 40,
                        onClick = { inputFuel = fuel3 },
                        texto = R.string.vehicle_fuel3
                    )
                }
            tipo2 ->
                Row (
                    modifier = Modifier.padding(20.dp, 10.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Boton(
                        w = 100, h = 40,
                        onClick = { inputSize = size1 },
                        texto = R.string.vehicle_size1
                    )
                    Boton(
                        w = 100, h = 40,
                        onClick = { inputSize = size2 },
                        texto = R.string.vehicle_size2
                    )
                    Boton(
                        w = 100, h = 40,
                        onClick = { inputSize = size3 },
                        texto = R.string.vehicle_size3
                    )
                }
            tipo3 -> null
        }
        // GPS //
        EntradaCheckBox(
            value = inputGPS,
            onValueChange = { inputGPS = !inputGPS },
            texto = R.string.ResumenPedido_HasGPS,
            modifier = Modifier.padding(20.dp, 10.dp)
        )
        // fecha //
        EntradaTexto(
            value = inputFecha,
            onValueChange = { inputFecha = it },
            texto = R.string.ResumenPedido_Date,
            modifier = Modifier.padding(20.dp, 10.dp)
        )
        // dias alquiler //
        EntradaNumero(
            value = inputDias,
            onValueChange = { inputDias = it },
            texto = R.string.ResumenPedido_RentDays,
            modifier = Modifier.padding(20.dp, 10.dp)
        )
        // precio total //
        FilaSalidaDato(
            texto = stringResource(R.string.ResumenPedido_Total),
            dato = "$precio " + stringResource(R.string.ResumenPedido_Coin),
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
                texto = R.string.button_accept
            )
        }
    }

}

// PREVIEW ----------------------------------------------------------

@Preview(showBackground = true)
@Composable
fun RealizarPedidoPreview() {
    AppTheme {
        PantallaRealizarPedido()
    }
}