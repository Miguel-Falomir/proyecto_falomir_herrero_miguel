// PAQUETE ----------------------------------------------------------

package com.example.proyecto_falomir_herrero_miguel

// LIBRERIAS --------------------------------------------------------

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

enum class Pantallas {
    Inicio,
    ListaPedidos,
    RealizarPedido,
    ResumenPedido,
    FormularioPago,
    ResumenPago
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
        composable(route = Pantallas.RealizarPedido.name) {
            PantallaRealizarPedido(
                modifier = Modifier.fillMaxSize()
            )
        }
        composable(route = Pantallas.ListaPedidos.name) {
            PantallaListaPedidos(
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