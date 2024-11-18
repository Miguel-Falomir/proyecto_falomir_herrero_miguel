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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.AppTheme
import com.example.proyecto_falomir_herrero_miguel.R
import com.example.proyecto_falomir_herrero_miguel.model.RentUIState
import com.example.proyecto_falomir_herrero_miguel.ui.theme.One
import com.example.proyecto_falomir_herrero_miguel.ui.viewmodel.MainViewModel

// METODO INICIAR PANTALLA ------------------------------------------

@Composable
fun PantallaRealizarPedido(
    onAcceptButton: () -> Unit,
    onCancelButton: () -> Unit,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
){
    RealizarPedido(
        onAcceptButton = onAcceptButton,
        onCancelButton = onCancelButton,
        viewModel = viewModel,
        modifier = modifier
    )
}

// METODO FORMULARIO PEDIDO -----------------------------------------

@Composable
fun RealizarPedido(
    onAcceptButton: () -> Unit,
    onCancelButton: () -> Unit,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
){
    // variables internas //
    var inputFecha by remember { mutableStateOf("") }
    var inputDias by remember { mutableStateOf("") }
    var inputTipo by remember { mutableStateOf("") }
    var inputMarca by remember { mutableStateOf("") }
    var inputModelo by remember { mutableStateOf("") }
    var inputFuel by remember { mutableStateOf("") }
    var inputSize by remember { mutableStateOf("") }
    var inputGPS by remember { mutableStateOf(false) }
    /*
    var precio: Double = calcularAlquiler(
        tipo = inputTipo,
        fuel = inputFuel,
        size = inputSize,
        hasGPS = inputGPS,
        dias = inputDias.toInt()
    )
     */
    var precio: Double = 0.0
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
                onClick = {
                    inputTipo = "0"
                    viewModel.updateVehicleType(inputTipo)
                    viewModel.updateRentPrice(precio.toString())
                },
                texto = R.string.vehicle_type1
            )
            Boton(
                w = 100, h = 40,
                onClick = {
                    inputTipo = "1"
                    viewModel.updateVehicleType(inputTipo)
                    viewModel.updateRentPrice(precio.toString())
                },
                texto = R.string.vehicle_type2
            )
            Boton(
                w = 100, h = 40,
                onClick = {
                    inputTipo = "2"
                    viewModel.updateVehicleType(inputTipo)
                    viewModel.updateRentPrice(precio.toString())
                },
                texto = R.string.vehicle_type3
            )
        }
        // marca //
        EntradaTexto(
            value = inputMarca,
            onValueChange = {
                inputMarca = it
                viewModel.updateVehicleBrand(inputMarca)
                viewModel.updateRentPrice(precio.toString())
            },
            texto = R.string.RealizarPedido_Brand,
            modifier = Modifier.padding(20.dp, 10.dp)
        )
        // modelo //
        EntradaTexto(
            value = inputModelo,
            onValueChange = {
                inputModelo = it
                viewModel.updateVehicleModel(inputMarca)
                viewModel.updateRentPrice(precio.toString())
            },
            texto = R.string.RealizarPedido_Model,
            modifier = Modifier.padding(20.dp, 10.dp)
        )
        // GPS //
        EntradaSwitch(
            value = inputGPS,
            onValueChange = {
                viewModel.updateVehicleGPS(!inputGPS)
                viewModel.updateRentPrice(precio.toString())
                inputGPS = !inputGPS
            },
            texto = R.string.ResumenPedido_HasGPS,
            modifier = Modifier.padding(20.dp, 10.dp)
        )
        // atributo concreto (combustible, cilindrada o nada) //
        when (viewModel.uiVehicleType) {
            "0" ->
                Text(
                    text = stringResource(R.string.ResumenPedido_Fuel),
                    fontFamily = One,
                    modifier = Modifier.padding(20.dp)
                )
            "1" ->
                Text(
                    text = stringResource(R.string.ResumenPedido_Size),
                    fontFamily = One,
                    modifier = Modifier.padding(20.dp)
                )
            else -> null
        }
        when (viewModel.uiVehicleType) {
            "0" ->
                Row (
                    modifier = Modifier.padding(20.dp, 10.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Boton(
                        w = 100, h = 40,
                        onClick = {
                            inputFuel = "0"
                            viewModel.updateVehicleFuel(inputFuel)
                            viewModel.updateRentPrice(precio.toString())
                        },
                        texto = R.string.vehicle_fuel1
                    )
                    Boton(
                        w = 100, h = 40,
                        onClick = {
                            inputFuel = "1"
                            viewModel.updateVehicleFuel(inputFuel)
                            viewModel.updateRentPrice(precio.toString())
                        },
                        texto = R.string.vehicle_fuel2
                    )
                    Boton(
                        w = 100, h = 40,
                        onClick = {
                            inputFuel = "2"
                            viewModel.updateVehicleFuel(inputFuel)
                            viewModel.updateRentPrice(precio.toString())
                        },
                        texto = R.string.vehicle_fuel3
                    )
                }
            "1" ->
                Row (
                    modifier = Modifier.padding(20.dp, 10.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Boton(
                        w = 100, h = 40,
                        onClick = {
                            inputSize = "2"
                            viewModel.updateVehicleSize(inputSize)
                            viewModel.updateRentPrice(precio.toString())
                        },
                        texto = R.string.vehicle_size1
                    )
                    Boton(
                        w = 100, h = 40,
                        onClick = {
                            inputSize = "1"
                            viewModel.updateVehicleSize(inputSize)
                            viewModel.updateRentPrice(precio.toString())
                        },
                        texto = R.string.vehicle_size2
                    )
                    Boton(
                        w = 100, h = 40,
                        onClick = {
                            inputSize = "0"
                            viewModel.updateVehicleSize(inputSize)
                            viewModel.updateRentPrice(precio.toString())
                        },
                        texto = R.string.vehicle_size3
                    )
                }
            else -> null
        }
        // fecha //
        EntradaTexto(
            value = inputFecha,
            onValueChange = {
                inputFecha = it
                viewModel.updateRentDate(inputFecha)
                viewModel.updateRentPrice(precio.toString())
            },
            texto = R.string.ResumenPedido_Date,
            modifier = Modifier.padding(20.dp, 10.dp)
        )
        // dias alquiler //
        EntradaNumero(
            value = inputDias,
            onValueChange = {
                inputDias = it
                viewModel.updateRentDays(inputDias)
                viewModel.updateRentPrice(precio.toString())
            },
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

// METODO CALCULAR ALQUILER -----------------------------------------

@Composable
fun calcularAlquiler(
    tipo: String,
    fuel: String,
    size: String,
    hasGPS: Boolean,
    dias: Int
): Double {
    // variable interna //
    var precio by remember { mutableStateOf(0.0) }
    // definir precio diario //
    when (tipo) {
        "0" ->
            precio = when (fuel) {
                "0" -> 25.0
                "1" -> 20.0
                else -> 15.0
            }
        "1" ->
            precio = when (size) {
                "0" -> 20.0
                "1" -> 15.0
                else -> 10.0
            }
        else -> precio = 5.0
    }
    // sumar GPS //
    if (hasGPS) { precio += 5.0 } else {}
    // multiplicar por dias alquiler //
    precio *= dias
    // devolver precio //
    return precio;
}

// PREVIEW ----------------------------------------------------------

@Preview(showBackground = true)
@Composable
fun RealizarPedidoPreview() {
    AppTheme {
        PantallaRealizarPedido(
            onCancelButton = {},
            onAcceptButton = {},
            viewModel = viewModel()
        )
    }
}