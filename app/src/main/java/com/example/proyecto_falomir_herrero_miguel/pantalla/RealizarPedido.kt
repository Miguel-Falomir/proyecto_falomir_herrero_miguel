// PAQUETE ----------------------------------------------------------

package com.example.proyecto_falomir_herrero_miguel.pantalla

// LIBRERIAS --------------------------------------------------------

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.AppTheme
import com.example.proyecto_falomir_herrero_miguel.Arranque
import com.example.proyecto_falomir_herrero_miguel.R
import com.example.proyecto_falomir_herrero_miguel.ui.theme.One

// METODO INICIAR PANTALLA ------------------------------------------

@Composable
fun PantallaRealizarPedido(modifier: Modifier = Modifier){
    FormularioPedido(modifier = modifier)
}

// METODO FORMULARIO PEDIDO -----------------------------------------

@Composable
fun FormularioPedido(modifier: Modifier = Modifier){
    // variables internas //
    var opcion by remember { mutableStateOf(0) };

    Column (
        modifier = modifier
            .padding(40.dp)
            .fillMaxWidth()
    ){
        // datos alquiler //
        formuRent(modifier = Modifier)
        // elegir clase vehiculo //
        Text(
            text = "Vehiculo",
            fontFamily = One
        )
        ElegirVehiculo(
            opcion = opcion,
            num = 0,
            onClick = { opcion = 0 },
            texto = R.string.vehicle_type1,
            modifier = Modifier
        )
        ElegirVehiculo(
            opcion = opcion,
            num = 1,
            onClick = { opcion = 1 },
            texto = R.string.vehicle_type1,
            modifier = Modifier
        )
        ElegirVehiculo(
            opcion = opcion,
            num = 2,
            onClick = { opcion = 2 },
            texto = R.string.vehicle_type1,
            modifier = Modifier
        )
        // espaciar //
        Spacer(modifier = Modifier.height(40.dp))
        // mostrar el correspondiente formulario //
        when (opcion) {
            0 -> formuCar(modifier = modifier)
            1 -> formuBike(modifier = modifier)
            2 -> formuScooter(modifier = modifier)
        }
        // mostrar precio //
        Row (
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "TOTAL",
                fontFamily = One
            )
            Text(
                text = "100.00 €"
            )
        }
        // botones cancelary aceptar //
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(
                modifier = Modifier
                    .width(160.dp)
                    .height(80.dp),
                onClick = {}
            ){
                Text(
                    text = "CANCELAR"
                )
            }
            Button(
                modifier = Modifier
                    .width(160.dp)
                    .height(80.dp),
                onClick = {}
            ){
                Text(
                    text = "ACEPTAR"
                )
            }
        }
    }
}

// METODO BOTON CLASE VEHICULO --------------------------------------

@Composable
fun ElegirVehiculo(
    opcion: Int,
    num: Int,
    onClick: () -> Unit,
    texto: Int,
    modifier: Modifier = Modifier
){
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        RadioButton (
            modifier = Modifier,
            selected = if (opcion == num) {true} else {false},
            onClick = onClick
        )
        Text(
            text = stringResource(texto)
        )
    }
}

// METODO FORMULARIO (ALQUILER) -------------------------------------

@Composable
fun formuRent(modifier: Modifier = Modifier){
    // variables internas //
    var inputFecha by remember { mutableStateOf("1970-01-01") }
    var inputDias by remember { mutableStateOf("0") }
    // elegir fecha y dias alquiler //
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Column(
            modifier = Modifier.width(160.dp)
        ){
            Text(
                text = "Fecha",
                fontFamily = One
            )
            OutlinedTextField(
                value = inputFecha,
                onValueChange = {inputFecha = it}
            )
        }
        Column(
            modifier = Modifier.width(160.dp)
        ){
            Text(
                text = "Dias Alquiler",
                fontFamily = One
            )
            OutlinedTextField(
                value = inputDias,
                onValueChange = {inputDias = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
    }
    // espaciar //
    Spacer(modifier = Modifier.height(40.dp))
}

// METODO FORMULARIO (CAR) ------------------------------------------

@Composable
fun formuCar(modifier: Modifier = Modifier){
    // variables internas //
    var inputMarca by remember { mutableStateOf("lorem") }
    var inputModelo by remember { mutableStateOf("ipsum") }
    var inputGPS by remember { mutableStateOf(false) }
    var elegirCombustible: Int by remember { mutableStateOf(0) }
    // formulario //
    Column (
        modifier = Modifier
    ){
        // elegir marca y modelo //
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(
                modifier = Modifier.width(160.dp)
            ){
                Text(
                    text = "Marca",
                    fontFamily = One
                )
                OutlinedTextField(
                    value = inputMarca,
                    onValueChange = {inputMarca = it}
                )
            }
            Column(
                modifier = Modifier.width(160.dp)
            ){
                Text(
                    text = "Modelo",
                    fontFamily = One
                )
                OutlinedTextField(
                    value = inputModelo,
                    onValueChange = {inputModelo = it}
                )
            }
        }
        // espaciar //
        Spacer(modifier = Modifier.height(40.dp))
        // elegir combustible //
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(
                modifier = Modifier.width(160.dp)
            ){
                Text(
                    text = "Combustible",
                    fontFamily = One
                )
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = if (elegirCombustible == 0) {
                            true
                        } else {
                            false
                        },
                        onClick = { elegirCombustible = 0 }
                    )
                    Text(
                        text = "Gasolina"
                    )
                }
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = if (elegirCombustible==1) {true} else {false},
                        onClick = {elegirCombustible = 1}
                    )
                    Text(
                        text = "Diesel"
                    )
                }
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = if (elegirCombustible==2) {true} else {false},
                        onClick = {elegirCombustible = 2}
                    )
                    Text(
                        text = "Eléctrico"
                    )
                }
            }
            // elegir GPS //
            Column(
                modifier = Modifier.width(160.dp)
            ){
                Text(
                    text = "Navegador GPS",
                    fontFamily = One
                )
                Row (
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Checkbox(
                        checked = inputGPS,
                        onCheckedChange = {inputGPS = !inputGPS}
                    )
                    Text(
                        text = if (inputGPS) {"Sí"} else {"No"}
                    )
                }
            }
        }
    }
}

// METODO FORMULARIO (BIKE) -----------------------------------------

@Composable
fun formuBike(modifier: Modifier = Modifier){

}

// METODO FORMULARIO (SCOOTER) --------------------------------------

@Composable
fun formuScooter(modifier: Modifier = Modifier){

}

// PREVIEW ----------------------------------------------------------

@Preview(showBackground = true)
@Composable
fun RealizarPedidoPreview() {
    AppTheme {
        PantallaRealizarPedido()
    }
}