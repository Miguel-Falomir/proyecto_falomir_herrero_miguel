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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme
import com.example.proyecto_falomir_herrero_miguel.R
import com.example.proyecto_falomir_herrero_miguel.data.Data
import com.example.proyecto_falomir_herrero_miguel.model.Bike
import com.example.proyecto_falomir_herrero_miguel.model.Car
import com.example.proyecto_falomir_herrero_miguel.model.Scooter
import com.example.proyecto_falomir_herrero_miguel.model.Vehicle
import com.example.proyecto_falomir_herrero_miguel.ui.theme.One

// METODO INICIAR PANTALLA ------------------------------------------

@Composable
fun PantallaRealizarPedido(modifier: Modifier = Modifier){
    RealizarPedido(modifier = modifier)
}

// METODO FORMULARIO PEDIDO -----------------------------------------

@Composable
fun RealizarPedido(modifier: Modifier = Modifier){
    // variables internas //
    var inputFecha by remember { mutableStateOf("1970-01-01") }
    var inputDias by remember { mutableStateOf("0") }
    var inputTipo by remember { mutableStateOf(0) }
    var vehiculo: Vehicle by remember { mutableStateOf( Data().VehicleList()[0] ) }
    // extructura general //

}

// METODO BOTON CLASE VEHICULO --------------------------------------

@Composable
fun OpcionVehiculo(
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

// PREVIEW ----------------------------------------------------------

@Preview(showBackground = true)
@Composable
fun RealizarPedidoPreview() {
    AppTheme {
        PantallaRealizarPedido()
    }
}

// CODIGO MUERTO ----------------------------------------------------

/*
// METODO FORMULARIO (ALQUILER) -------------------------------------

@Composable
fun formuRent(
    modifier: Modifier = Modifier
){

}

// METODO FORMULARIO (CAR) ------------------------------------------

@Composable
fun formuCar(modifier: Modifier = Modifier){
    // variables internas //
    var inputMarca by remember { mutableStateOf("lorem") }
    var inputModelo by remember { mutableStateOf("ipsum") }
    var inputGPS by remember { mutableStateOf(false) }
    var inputCombustible by remember { mutableStateOf("") }
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
                        selected = if (elegirCombustible == 0) {true} else {false},
                        onClick = {
                            elegirCombustible = 0
                            inputCombustible = R.string.Check_Gas.toString()
                        }
                    )
                    Text(
                        text = stringResource(R.string.Check_Gas)
                    )
                }
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = if (elegirCombustible == 1) {true} else {false},
                        onClick = {
                            elegirCombustible = 1
                            inputCombustible = R.string.Check_Diesel.toString()
                        }
                    )
                    Text(
                        text = stringResource(R.string.Check_Diesel)
                    )
                }
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = if (elegirCombustible == 2) {true} else {false},
                        onClick = {
                            elegirCombustible = 2
                            inputCombustible = R.string.Check_Electric.toString()
                        }
                    )
                    Text(
                        text = stringResource(R.string.Check_Electric)
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
                        text = if (inputGPS) {
                            stringResource(R.string.Check_GPS_Y)
                        } else {
                            stringResource(R.string.Check_GPS_N)
                        }
                    )
                }
            }
        }
    }
    newCar(
        brand = inputMarca,
        model = inputModelo,
        hasGPS = inputGPS,
        fuel = inputCombustible
    )
}
fun newCar(
    brand: String,
    model: String,
    hasGPS: Boolean,
    fuel: String
) : Car {
    return Car(
        brandId = brand.toInt(),
        modelId = model.toInt(),
        hasGPS = hasGPS.toString().toInt(),
        fuelId = fuel.toInt()
    )
}

// METODO FORMULARIO (BIKE) -----------------------------------------

@Composable
fun formuBike(modifier: Modifier = Modifier){
    // variables internas //
    var inputMarca by remember { mutableStateOf("lorem") }
    var inputModelo by remember { mutableStateOf("ipsum") }
    var inputGPS by remember { mutableStateOf(false) }
    var inputCilindrada by remember { mutableStateOf("") }
    var elegirCilindrada: Int by remember { mutableStateOf(0) }
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
                        selected = if (elegirCilindrada == 0) {true} else {false},
                        onClick = {
                            elegirCilindrada = 0
                            inputCilindrada = R.string.Check_50.toString()
                        }
                    )
                    Text(
                        text = stringResource(R.string.Check_50)
                    )
                }
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = if (elegirCilindrada == 1) {true} else {false},
                        onClick = {
                            elegirCilindrada = 2
                            inputCilindrada = R.string.Check_125.toString()
                        }
                    )
                    Text(
                        text = stringResource(R.string.Check_125)
                    )
                }
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = if (elegirCilindrada == 2) {true} else {false},
                        onClick = {
                            elegirCilindrada = 2
                            inputCilindrada = R.string.Check_250.toString()
                        }
                    )
                    Text(
                        text = stringResource(R.string.Check_250)
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
                        text = if (inputGPS)  {
                            stringResource(R.string.Check_GPS_Y)
                        } else {
                            stringResource(R.string.Check_GPS_N)
                        }
                    )
                }
            }
        }
    }
    newBike(
        brand = inputMarca,
        model = inputModelo,
        hasGPS = inputGPS,
        size = inputCilindrada
    )
}
fun newBike(
    brand: String,
    model: String,
    hasGPS: Boolean,
    size: String
) : Bike {
    return Bike(
        brandId = brand.toInt(),
        modelId = model.toInt(),
        hasGPS = hasGPS.toString().toInt(),
        sizeId = size.toInt()
    )
}

// METODO FORMULARIO (SCOOTER) --------------------------------------

@Composable
fun formuScooter(modifier: Modifier = Modifier){
    // variables internas //
    var inputMarca by remember { mutableStateOf("lorem") }
    var inputModelo by remember { mutableStateOf("ipsum") }
    var inputGPS by remember { mutableStateOf(false) }
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
        // elegir GPS //
        Column(
            modifier = Modifier.fillMaxWidth()
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
                    text = if (inputGPS)  {
                        stringResource(R.string.Check_GPS_Y)
                    } else {
                        stringResource(R.string.Check_GPS_N)
                    }
                )
            }
        }
    }
    newScooter(
        brand = inputMarca,
        model = inputModelo,
        hasGPS = inputGPS
    )
}


fun newScooter(
    brand: String,
    model: String,
    hasGPS: Boolean
) : Scooter {
    return Scooter(
        brandId = brand.toInt(),
        modelId = model.toInt(),
        hasGPS = hasGPS.toString().toInt()
    )
}
 */

// MAS CODIGO MUERTO ------------------------------------------------

/*
Column (
        modifier = modifier
            .padding(40.dp)
            .fillMaxWidth()
    ){
        // datos alquiler //
        // elegir fecha y dias alquiler //
        Row (
            modifier = Modifier.fillMaxWidth().height(200.dp),
            verticalAlignment = Alignment.Top,
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
                Spacer(modifier = Modifier.weight(1F))
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
            Column (
                modifier = Modifier.width(160.dp)
            ){
                Text(
                    text = "Vehiculo",
                    fontFamily = One
                )
                OpcionVehiculo(
                    opcion = inputTipo,
                    num = 0,
                    onClick = { inputTipo = 0 },
                    texto = R.string.vehicle_type1,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.weight(1F))
                OpcionVehiculo(
                    opcion = inputTipo,
                    num = 1,
                    onClick = { inputTipo = 1 },
                    texto = R.string.vehicle_type2,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.weight(1F))
                OpcionVehiculo(
                    opcion = inputTipo,
                    num = 2,
                    onClick = { inputTipo = 2 },
                    texto = R.string.vehicle_type3,
                    modifier = Modifier
                )
            }
        }
        // espaciar //
        Spacer(modifier = Modifier.height(40.dp))
        // mostrar el correspondiente formulario //
        when (inputTipo) {
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
                /*
                text = when (vehiculo) {
                    is Car -> "turismo"
                    is Bike -> "moto"
                    is Scooter -> "patinene"
                    else -> "error"
                }
                 */
            )
        }
        // botones cancelar y aceptar //
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
 */