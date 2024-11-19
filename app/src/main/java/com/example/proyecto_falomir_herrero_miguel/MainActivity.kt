// PAQUETE ----------------------------------------------------------

package com.example.proyecto_falomir_herrero_miguel

// LIBRERIAS --------------------------------------------------------

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.example.proyecto_falomir_herrero_miguel.pantalla.PantallaFormularioPago
import com.example.proyecto_falomir_herrero_miguel.pantalla.PantallaInicio
import com.example.proyecto_falomir_herrero_miguel.pantalla.PantallaListaPedidos
import com.example.proyecto_falomir_herrero_miguel.pantalla.PantallaRealizarPedido
import com.example.proyecto_falomir_herrero_miguel.pantalla.PantallaResumenPago
import com.example.proyecto_falomir_herrero_miguel.pantalla.PantallaResumenPedido
import com.example.proyecto_falomir_herrero_miguel.ui.viewmodel.MainViewModel

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
                // Scaffold se declara dentro de 'Navegador()'
                // Por alguna razon, no hace falta pasarle 'navController' ni 'viewModel'
                Navegador()
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
    navController: NavHostController = rememberNavController(),
    viewModel: MainViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    // Guardar pila de retroceso
    // (lista de pantallas que hay detras de la pantalla actual)
    // En pantalla inicio, esta pila queda vacia
    val pilaRetroceso by navController.currentBackStackEntryAsState()

    // Guardar pantalla actual
    // Contiene un booleano que indica si hay mas pantallas detras
    // La pantalla inicial deberia tener la pila de retroceso vacia
    val pantallaActual = Pantallas.valueOf(
        value = pilaRetroceso?.destination?.route ?: Pantallas.Inicio.name
    )

    Scaffold (
        topBar = {
            BarraSuperior(
                pantallaActual = pantallaActual,
                puedeRetroceder = navController.previousBackStackEntry != null,
                onRetroceso = {navController.navigateUp()}
            )
        }
    ) { innerPadding ->
        // Guardar estado de objetos actuales
        val rentState by viewModel.rentUIState.collectAsState()

        // 'navController' gestiona la navegacion entre pantallas.
        // 'navHost' alberga la pantalla actual, en la que se encuentra el usuario al momento.
        NavHost(
            navController = navController,
            startDestination = Pantallas.Inicio.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Cada 'composable' define un grafo de navegacion.
            // Esto es, una pantalla con las rutas de sus botones de navegacion.
            composable(route = Pantallas.Inicio.name) {
                PantallaInicio(
                    onOrderButton = { navController.navigate(Pantallas.RealizarPedido.name) },
                    onListButton = { navController.navigate(Pantallas.ListaPedidos.name) },
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
                    onCancelButton = { navController.navigate(Pantallas.Inicio.name) },
                    onAcceptButton = {
                        viewModel.updateRent()
                        navController.navigate(Pantallas.ResumenPedido.name) },
                    viewModel = viewModel,
                    modifier = Modifier.fillMaxSize()
                )
            }
            composable(route = Pantallas.ResumenPedido.name) {
                PantallaResumenPedido(
                    onCancelButton = { navController.navigate(Pantallas.RealizarPedido.name) },
                    onAcceptButton = { navController.navigate(Pantallas.FormularioPago.name) },
                    rentState = rentState,
                    modifier = Modifier.fillMaxSize()
                )
            }
            composable(route = Pantallas.FormularioPago.name) {
                PantallaFormularioPago(
                    onCancelButton = { navController.navigate(Pantallas.ResumenPedido.name) },
                    onPayButton = {
                        viewModel.updateRent()
                        navController.navigate(Pantallas.ResumenPago.name)
                    },
                    viewModel = viewModel,
                    modifier = Modifier.fillMaxSize()
                )
            }
            composable(route = Pantallas.ResumenPago.name) {
                PantallaResumenPago(
                    onCancelButton = { navController.navigate(Pantallas.FormularioPago.name) },
                    onAcceptButton = { navController.navigate(Pantallas.Inicio.name) },
                    rentState = rentState,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

// METODO BARRA SUPERIOR --------------------------------------------

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSuperior(
    pantallaActual: Pantallas,
    puedeRetroceder: Boolean,
    onRetroceso: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(
        // Titulo de la pantalla actual.
        title = {
            Text( stringResource(pantallaActual.titulo))
        },
        // Paleta del elemento,
        // se recomienda aplicar los colores primarios del tema.
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        // Mostrar 'IconButton' de retroceso si la pila no esta vacia.
        // Este boton retrocede siguiendo la pila al reves
        // Recorrido: 1 -> 2 -> 3 -> 2
        // IconButon: 2 -> 3 -> 2 -> 1
        navigationIcon = {
            if(puedeRetroceder) {
                IconButton(onClick = onRetroceso) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.title_back)
                    )
                }
            }
        },
        modifier = modifier
    )
}

// PREVIEW ----------------------------------------------------------

@Preview(showBackground = true)
@Composable
fun Preview() {
    AppTheme {
        Navegador()
    }
}