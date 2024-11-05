// PAQUETE ----------------------------------------------------------

package com.example.proyecto_falomir_herrero_miguel.pantalla

// LIBRERIAS --------------------------------------------------------

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.AppTheme
import com.example.proyecto_falomir_herrero_miguel.R
import com.example.proyecto_falomir_herrero_miguel.data.Data
import com.example.proyecto_falomir_herrero_miguel.model.User

// METODO INICIAR PANTALLA ------------------------------------------

@Composable
fun PantallaInicio(modifier: Modifier = Modifier){
    Column (
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        CartaUser(
            user = Data().UserDemo(),
            color = Color.LightGray,
            modifier = modifier
        )
        Spacer(
            modifier = Modifier.weight(1F)
        )
        ColumnaBotones(
            listOf(
                R.string.button_OrderRent,
                R.string.button_ListRents
            ),
            modifier = modifier
        )
    }

}

@Composable
fun CartaUser(user: User, color: Color, modifier: Modifier = Modifier){
    Card (
        modifier = Modifier.fillMaxWidth(),
        shape = RectangleShape,
        colors = CardColors(
            containerColor = color,
            contentColor = Color.Unspecified,
            disabledContainerColor = color,
            disabledContentColor = Color.Unspecified
        )
    ){
        DatosUser(user, modifier)
    }
}



@Composable
fun DatosUser(user: User, modifier: Modifier = Modifier){
    Column (
        modifier = Modifier.padding(22.dp)
    ){
        Row (
            modifier = Modifier.padding(0.dp, 8.dp)
        ){
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null
            )
            Text(
                text = user.name,
                modifier = Modifier.padding(5.dp, 0.dp)
            )
        }
        Row (
            modifier = Modifier.padding(0.dp, 8.dp)
        ){
            Spacer(
                modifier = Modifier.width(24.dp)
            )
            Text(
                text = user.surnames,
                modifier = Modifier.padding(5.dp, 0.dp)
            )
        }
        Row (
            modifier = Modifier.padding(0.dp, 8.dp)
        ){
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null
            )
            Text(
                text = user.email,
                modifier = Modifier.padding(5.dp, 0.dp)
            )
        }
        Row (
            modifier = Modifier.padding(0.dp, 8.dp)
        ){
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = null
            )
            Text(
                text = user.phone,
                modifier = Modifier.padding(5.dp, 0.dp)
            )
        }
    }
    /*
    Column (
        modifier = modifier
    ){
        Text(
            text = stringResource(user.nameId)
        )
        Text(
            text = stringResource(user.surnamesId)
        )
        Text(
            text = stringResource(user.emailId)
        )
        Text(
            text = stringResource(user.phoneNumberId)
        )
    }
    */
}

@Preview(showBackground = true)
@Composable
fun InicioPreview() {
    AppTheme {
        PantallaInicio()
    }
}