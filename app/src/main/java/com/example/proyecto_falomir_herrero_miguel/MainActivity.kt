// PAQUETE ----------------------------------------------------------

package com.example.proyecto_falomir_herrero_miguel

// LIBRERIAS --------------------------------------------------------

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.example.proyecto_falomir_herrero_miguel.pantalla.PantallaFormularioPago
import com.example.proyecto_falomir_herrero_miguel.pantalla.PantallaInicio
import com.example.proyecto_falomir_herrero_miguel.pantalla.PantallaListaPedidos
import com.example.proyecto_falomir_herrero_miguel.pantalla.PantallaRealizarPedido
import com.example.proyecto_falomir_herrero_miguel.pantalla.PantallaResumenPago
import com.example.proyecto_falomir_herrero_miguel.pantalla.PantallaResumenPedido
import com.example.proyecto_falomir_herrero_miguel.pantalla.RealizarPedido

// LISTA PANTALLAS --------------------------------------------------

enum class Pantallas (
    @StringRes val titulo: Int
) {
    Inicio(titulo = R.string.title_inicio),
    ListaPedidos(titulo = R.string.title_listaPedido),
    RealizarPedido(titulo = R.string.title_realizarPedido),
    ResumenPedido(titulo = R.string.title_resumenPedido),
    FormularioPago(titulo = R.string.title_formularioPago),
    ResumenPago(titulo = R.string.title_resumenPago)
}

// METODO INICIAR PANTALLA ------------------------------------------

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Navegador(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// METODO ARRANQUE --------------------------------------------------

@Composable
fun Arranque(modifier: Modifier = Modifier) {
    // PantallaInicio(modifier) //
}

// METODO NAVEGAR ENTRE PANTALLAS -----------------------------------

@Composable
fun Navegador(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    // 'navController' gestiona la navegacion entre pantallas.
    // 'navHost' alberga la pantalla actual, en la que se encuentra el usuario al momento.
    NavHost(
        navController = navController,
        startDestination = Pantallas.Inicio.name,
        modifier = modifier
    ) {
        // Cada 'composable' define un grafo de navegacion.
        // Esto es, una pantalla con las rutas de sus botones de navegacion.
        composable(route = Pantallas.Inicio.name) {
            PantallaInicio(
                onOrderButton = {navController.navigate(Pantallas.RealizarPedido.name)},
                onListButton = {navController.navigate(Pantallas.ListaPedidos.name)},
                modifier = Modifier.fillMaxSize()
            )
        }
        composable(route = Pantallas.ListaPedidos.name) {
            PantallaListaPedidos(
                modifier = Modifier.fillMaxSize()
            )
        }
        composable(route = Pantallas.RealizarPedido.name) {
            PantallaRealizarPedido(
                onCancelButton = {navController.navigate(Pantallas.Inicio.name)},
                onAcceptButton = {navController.navigate(Pantallas.ResumenPedido.name)},
                modifier = Modifier.fillMaxSize()
            )
        }
        composable(route = Pantallas.ResumenPedido.name){
            PantallaResumenPedido(
                onCancelButton = {navController.navigate(Pantallas.RealizarPedido.name)},
                onAcceptButton = {navController.navigate(Pantallas.FormularioPago.name)},
                modifier = Modifier.fillMaxSize()
            )
        }
        composable(route = Pantallas.FormularioPago.name){
            PantallaFormularioPago(
                onCancelButton = {navController.navigate(Pantallas.ResumenPedido.name)},
                onPayButton = {navController.navigate(Pantallas.ResumenPago.name)},
                modifier = Modifier.fillMaxSize()
            )
        }
        composable(route = Pantallas.ResumenPago.name){
            PantallaResumenPago(
                onCancelButton = {navController.navigate(Pantallas.FormularioPago.name)},
                onAcceptButton = {navController.navigate(Pantallas.Inicio.name)},
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

// PREVIEW ----------------------------------------------------------

@Preview(showBackground = true)
@Composable
fun Preview() {
    AppTheme {
        Arranque()
    }
}