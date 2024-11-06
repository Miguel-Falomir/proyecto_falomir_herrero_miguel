// PAQUETE ----------------------------------------------------------

package com.example.proyecto_falomir_herrero_miguel.pantalla

// LIBRERIAS --------------------------------------------------------

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import com.example.proyecto_falomir_herrero_miguel.data.Data
import com.example.proyecto_falomir_herrero_miguel.model.BikeUIState
import com.example.proyecto_falomir_herrero_miguel.model.CarUIState
import com.example.proyecto_falomir_herrero_miguel.model.RentUIState
import com.example.proyecto_falomir_herrero_miguel.model.ScooterUIState

// METODO INICIAR PANTALLA ------------------------------------------

@Composable
fun PantallaListaPedidos(modifier: Modifier = Modifier){
    ColumnaPedidos( Data().RentList(), modifier )
}

// METODO COLUMNA PEDIDOS -------------------------------------------

@Composable
fun ColumnaPedidos (data: List<RentUIState>, modifier: Modifier = Modifier) {
    LazyColumn (modifier = modifier) {
        items(data) { token ->
            CartaPedido(token, modifier)
        }
    }
}

// METODO CARTA PEDIDO ----------------------------------------------

@Composable
fun CartaPedido (token: RentUIState, modifier: Modifier = Modifier) {
    // variables internas //
    var binario: Boolean by remember { mutableStateOf( false ) }

    Card (
        modifier = Modifier.padding(40.dp, 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.Left
        ) {
            /*
            // Hacer objeto 'Image' //
            Image(
                painter = painterResource(render.drawResId),
                contentDescription = stringResource(render.stringResId),
                modifier = Modifier
                    .padding(0.dp)
                    .width(150.dp)
                    .aspectRatio(1.0F)
            )
            */
            // Imprimir nombre objeto //
            Text(
                text = token.vehicleUIState.brand,
                modifier = Modifier.padding(start = 20.dp),
                style = MaterialTheme.typography.headlineSmall,
            )
            Text(" ")
            Text(
                text = token.vehicleUIState.model,
                modifier = Modifier,
                style = MaterialTheme.typography.headlineSmall,
            )
            // espaciar //
            Spacer(modifier = Modifier.weight(1F))
            // declarar objeto 'IconButton', con icono dentro //
            IconoExpansible(
                binario = binario,
                onClick = {binario = !binario},
                modifier = modifier
            )
        }
        if (binario) {
            when (token.vehicleUIState) {
                is CarUIState -> DetallesCar(token, token.vehicleUIState, modifier)
                is BikeUIState -> DetallesBike(token, token.vehicleUIState, modifier)
                is ScooterUIState -> DetallesScooter(token, token.vehicleUIState, modifier)
                else -> Text(text = stringResource(R.string.ClassError))
            }
        }
    }
}

// METODO ICONO EXPANSIBLE ------------------------------------------

@Composable
fun IconoExpansible(
    binario: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .padding(10.dp)
            .size(40.dp),
    ) {
        Icon(
            imageVector = if (binario) {
                Icons.Default.KeyboardArrowUp
            } else {
                Icons.Default.KeyboardArrowDown
            },
            contentDescription = if (binario) {
                stringResource(R.string.IconButton_Open)
            } else {
                stringResource(R.string.IconButton_Close)
            },
            modifier = Modifier.size(30.dp)
        )
    }
}

// METODO DETALLES PEDIDO (CAR) -------------------------------------

@Composable
fun DetallesCar(rentUIState: RentUIState, carUIState: CarUIState, modifier: Modifier = Modifier){
    Column (
        modifier = Modifier.padding(20.dp)
    ){
        // mostrar si tiene GPS //
        Row (
            modifier = Modifier
        ){
            Text(
                text = stringResource(R.string.ResumenPedido_HasGPS)
            )
            Spacer(modifier = Modifier.weight(1F))
            Text(
                text = if(carUIState.hasGPS) {
                    stringResource(R.string.Check_Y)
                } else {
                    stringResource(R.string.Check_Y)
                }
            )
        }
        // mostrar combustible //
        Row (
            modifier = Modifier
        ){
            Text(
                text = stringResource(R.string.ResumenPedido_Fuel)
            )
            Spacer(modifier = Modifier.weight(1F))
            Text(
                text = carUIState.fuel
            )
        }
        // mostrar fecha
        Row (
            modifier = Modifier
        ){
            Text(
                text = stringResource(R.string.ResumenPedido_Date)
            )
            Spacer(modifier = Modifier.weight(1F))
            Text(
                text = rentUIState.date
            )
        }
        // mostrar dias
        Row (
            modifier = Modifier
        ){
            Text(
                text = stringResource(R.string.ResumenPedido_RentDays)
            )
            Spacer(modifier = Modifier.weight(1F))
            Text(
                text = rentUIState.rentDays
            )
            Text(
                text = stringResource(R.string.ResumenPedido_Time)
            )
        }
        // mostrar precio
        Row (
            modifier = Modifier
        ){
            Text(
                text = stringResource(R.string.ResumenPedido_Size)
            )
            Spacer(modifier = Modifier.weight(1F))
            Text(
                text = rentUIState.price.toString()
            )
            Text(
                text = stringResource(R.string.ResumenPedido_Coin)
            )
        }
    }
}

// METODO DETALLES PEDIDO (BIKE) ------------------------------------

@Composable
fun DetallesBike(rentUIState: RentUIState, bikeUIState: BikeUIState, modifier: Modifier = Modifier){
    Column (
        modifier = Modifier.padding(20.dp)
    ){
        // mostrar si tiene GPS //
        Row (
            modifier = Modifier
        ){
            Text(
                text = stringResource(R.string.ResumenPedido_HasGPS)
            )
            Spacer(modifier = Modifier.weight(1F))
            Text(
                text = if(bikeUIState.hasGPS) {
                    stringResource(R.string.Check_Y)
                } else {
                    stringResource(R.string.Check_N)
                }
            )
        }
        // mostrar cilindrada
        Row (
            modifier = Modifier
        ){
            Text(
                text = stringResource(R.string.ResumenPedido_Size)
            )
            Spacer(modifier = Modifier.weight(1F))
            Text(
                text = bikeUIState.size
            )
        }
        // mostrar fecha
        Row (
            modifier = Modifier
        ){
            Text(
                text = stringResource(R.string.ResumenPedido_Date)
            )
            Spacer(modifier = Modifier.weight(1F))
            Text(
                text = rentUIState.date
            )
        }
        // mostrar dias
        Row (
            modifier = Modifier
        ){
            Text(
                text = stringResource(R.string.ResumenPedido_RentDays)
            )
            Spacer(modifier = Modifier.weight(1F))
            Text(
                text = rentUIState.rentDays
            )
            Text(
                text = stringResource(R.string.ResumenPedido_Time)
            )
        }
        // mostrar precio
        Row (
            modifier = Modifier
        ){
            Text(
                text = stringResource(R.string.ResumenPedido_Total)
            )
            Spacer(modifier = Modifier.weight(1F))
            Text(
                text = rentUIState.price.toString()
            )
            Text(
                text = stringResource(R.string.ResumenPedido_Coin)
            )
        }
    }
}

// METODO DETALLES PEDIDO (SCOOTER) ---------------------------------

@Composable
fun DetallesScooter(rentUIState: RentUIState, scooterUIState: ScooterUIState, modifier: Modifier = Modifier){
    Column (
        modifier = Modifier.padding(20.dp)
    ){
        // mostrar si tiene GPS //
        Row (
            modifier = Modifier
        ){
            Text(
                text = stringResource(R.string.ResumenPedido_HasGPS)
            )
            Spacer(modifier = Modifier.weight(1F))
            Text(
                text = if(scooterUIState.hasGPS) {
                    stringResource(R.string.Check_Y)
                } else {
                    stringResource(R.string.Check_N)
                }
            )
        }
        // mostrar fecha
        Row (
            modifier = Modifier
        ){
            Text(
                text = stringResource(R.string.ResumenPedido_Date)
            )
            Spacer(modifier = Modifier.weight(1F))
            Text(
                text = rentUIState.date
            )
        }
        // mostrar dias
        Row (
            modifier = Modifier
        ){
            Text(
                text = stringResource(R.string.ResumenPedido_RentDays)
            )
            Spacer(modifier = Modifier.weight(1F))
            Text(
                text = rentUIState.rentDays
            )
            Text(
                text = stringResource(R.string.ResumenPedido_Time)
            )
        }
        // mostrar precio
        Row (
            modifier = Modifier
        ){
            Text(
                text = stringResource(R.string.ResumenPedido_Size)
            )
            Spacer(modifier = Modifier.weight(1F))
            Text(
                text = rentUIState.price.toString()
            )
            Text(
                text = stringResource(R.string.ResumenPedido_Coin)
            )
        }
    }
}

// PREVIEW ----------------------------------------------------------

@Preview(showBackground = true)
@Composable
fun ListaPedidoPreview() {
    AppTheme {
        PantallaListaPedidos()
    }
}