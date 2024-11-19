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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.AppTheme
import com.example.proyecto_falomir_herrero_miguel.R
import com.example.proyecto_falomir_herrero_miguel.model.Rent
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
    var precio: Double = precioEnTienpoReal(
        tipo = inputTipo,
        fuel = inputFuel,
        size = inputSize,
        GPS = inputGPS,
        dias = inputDias
    )
     */
    var precio :Double = 0.0
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
                    viewModel.insertVehicleType(inputTipo)
                },
                texto = R.string.vehicle_type1
            )
            Boton(
                w = 100, h = 40,
                onClick = {
                    inputTipo = "1"
                    viewModel.insertVehicleType(inputTipo)
                },
                texto = R.string.vehicle_type2
            )
            Boton(
                w = 100, h = 40,
                onClick = {
                    inputTipo = "2"
                    viewModel.insertVehicleType(inputTipo)
                },
                texto = R.string.vehicle_type3
            )
        }
        // marca //
        EntradaTexto(
            value = inputMarca,
            onValueChange = {
                inputMarca = it
                viewModel.insertVehicleBrand(inputMarca)
            },
            texto = R.string.RealizarPedido_Brand,
            modifier = Modifier.padding(20.dp, 10.dp)
        )
        // modelo //
        EntradaTexto(
            value = inputModelo,
            onValueChange = {
                inputModelo = it
                viewModel.insertVehicleModel(inputModelo)
            },
            texto = R.string.RealizarPedido_Model,
            modifier = Modifier.padding(20.dp, 10.dp)
        )
        // GPS //
        EntradaSwitch(
            value = inputGPS,
            onValueChange = {
                viewModel.insertVehicleGPS(!inputGPS)
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
                            viewModel.insertVehicleFuel(inputFuel)
                        },
                        texto = R.string.vehicle_fuel1
                    )
                    Boton(
                        w = 100, h = 40,
                        onClick = {
                            inputFuel = "1"
                            viewModel.insertVehicleFuel(inputFuel)
                        },
                        texto = R.string.vehicle_fuel2
                    )
                    Boton(
                        w = 100, h = 40,
                        onClick = {
                            inputFuel = "2"
                            viewModel.insertVehicleFuel(inputFuel)
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
                            inputSize = "0"
                            viewModel.insertVehicleSize(inputSize)
                        },
                        texto = R.string.vehicle_size1
                    )
                    Boton(
                        w = 100, h = 40,
                        onClick = {
                            inputSize = "1"
                            viewModel.insertVehicleSize(inputSize)
                        },
                        texto = R.string.vehicle_size2
                    )
                    Boton(
                        w = 100, h = 40,
                        onClick = {
                            inputSize = "2"
                            viewModel.insertVehicleSize(inputSize)
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
                viewModel.insertRentDate(inputFecha)
            },
            texto = R.string.ResumenPedido_Date,
            modifier = Modifier.padding(20.dp, 10.dp)
        )
        // dias alquiler //
        EntradaNumero(
            value = inputDias,
            onValueChange = {
                inputDias = it
                viewModel.insertRentDays(inputDias)
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

@Composable
fun precioEnTienpoReal(
    tipo: String,
    fuel: String,
    size: String,
    GPS: Boolean,
    dias: String
) : Double {
    var rentPrice: Double = 0.0

    when (tipo) {
        "0" -> rentPrice = when (fuel) {
            "0" -> 25.0
            "1" -> 20.0
            "2" -> 15.0
            else -> 0.0
        }
        "1" -> rentPrice = when (size) {
            "0" -> 15.0
            "1" -> 20.0
            "2" -> 25.0
            else -> 0.0
        }
        else -> rentPrice = 5.0
    }

    if(GPS){ rentPrice += 5.0 } else{}

    rentPrice *= dias.toInt()

    return rentPrice
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