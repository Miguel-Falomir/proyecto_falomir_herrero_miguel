// PAQUETE ----------------------------------------------------------

package com.example.proyecto_falomir_herrero_miguel.pantalla

// LIBRERIAS --------------------------------------------------------

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

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
        modifier = modifier
    ){
        Text(
            text = stringResource(texto),
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