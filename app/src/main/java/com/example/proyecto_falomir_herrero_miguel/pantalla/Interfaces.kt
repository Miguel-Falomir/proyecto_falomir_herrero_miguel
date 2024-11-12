// PAQUETE ----------------------------------------------------------

package com.example.proyecto_falomir_herrero_miguel.pantalla

// LIBRERIAS --------------------------------------------------------

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto_falomir_herrero_miguel.R
import com.example.proyecto_falomir_herrero_miguel.ui.theme.One

// METODO BOTON -----------------------------------------------------

@Composable
fun Boton(
    onClick: () -> Unit,
    w: Int,
    h: Int,
    texto: Int,
    modifier: Modifier = Modifier
){
    Button(
        modifier = Modifier
            .width(w.dp)
            .height(h.dp),
        onClick = onClick
    ) {
        Text(
            text = stringResource(texto)
        )
    }
}

// METODO FILA BOTONES ----------------------------------------------

@Composable
fun FilaBotones(
    list: List<Int>,
    modifier: Modifier = Modifier
){
    Row (
        modifier = Modifier.fillMaxWidth()
    ){
        list.forEach{ resource ->
            Button (
                modifier = Modifier.padding(20.dp).weight(1F).height(80.dp),
                onClick = {}
            ){
                Text(
                    text = stringResource(resource)
                )
            }
        }
    }
}

// METODO COLUMNA BOTONES -------------------------------------------

@Composable
fun ColumnaBotones(
    list: List<Int>,
    modifier: Modifier = Modifier
){
    Column(
        modifier = Modifier.padding(20.dp).fillMaxWidth()
    ){
        list.forEach{ resource ->
            Button (
                modifier = Modifier.padding(30.dp).fillMaxWidth().height(80.dp),
                onClick = {}
            ){
                Text(
                    text = stringResource(resource)
                )
            }
        }
    }
}

// METODO FILA ENTRADA TEXTO ----------------------------------------

@Composable
fun EntradaTexto(
    onValueChange: (String) -> Unit,
    value: String,
    texto: Int,
    modifier: Modifier = Modifier
){
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = stringResource(texto),
            fontFamily = One,
            modifier = Modifier.weight(1F)
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.weight(1F)
        )
    }
}

// METODO FILA ENTRADA NUMERO ---------------------------------------

@Composable
fun EntradaNumero(
    onValueChange: (String) -> Unit,
    value: String,
    texto: Int,
    modifier: Modifier = Modifier
){
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = stringResource(texto),
            fontFamily = One,
            modifier = Modifier.weight(1F)
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.weight(1F)
        )
    }
}

// METODO FILA ENTRADA CHECKBOX ----------------------------------------

@Composable
fun EntradaCheckBox(
    onValueChange: (Boolean) -> Unit,
    value: Boolean,
    texto: Int,
    modifier: Modifier = Modifier
){
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = stringResource(texto),
            fontFamily = One,
            modifier = Modifier.weight(1F)
        )
        Checkbox(
            checked = value,
            onCheckedChange = onValueChange
        )
        Text(
            text = if (value) {
                stringResource(R.string.Check_Y)
            } else {
                stringResource(R.string.Check_N)
            }
        )
    }
}

// METODO FILA ENTRADA SWITCH ----------------------------------------

@Composable
fun EntradaSwitch(
    onValueChange: (Boolean) -> Unit,
    value: Boolean,
    texto: Int,
    modifier: Modifier = Modifier
){
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = stringResource(texto),
            fontFamily = One,
            modifier = Modifier.weight(1F)
        )
        Switch(
            checked = value,
            onCheckedChange = onValueChange
        )
    }
}

// METODO FILA MOSTRAR DATO -----------------------------------------

@Composable
fun FilaSalidaDato(
    texto: String,
    dato: String,
    modifier: Modifier = Modifier
){
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = texto,
            fontFamily = One,
            modifier = Modifier.weight(1F)
        )
        Text(
            text = dato
        )
    }
}

// METODO FILA MOSTRAR DATO AUXILIAR --------------------------------

@Composable
fun FilaDatoAuxiliar(
    texto: String,
    dato: String,
    modifier: Modifier = Modifier
){
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = texto,
            fontFamily = One,
            modifier = Modifier.weight(1F)
        )
        Text(
            text = dato
        )
    }
}

