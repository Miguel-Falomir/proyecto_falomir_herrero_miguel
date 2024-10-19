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
import com.example.compose.AppTheme
import com.example.proyecto_falomir_herrero_miguel.pantalla.PantallaFormularioPago
import com.example.proyecto_falomir_herrero_miguel.pantalla.PantallaInicio
import com.example.proyecto_falomir_herrero_miguel.pantalla.PantallaListaPedidos
import com.example.proyecto_falomir_herrero_miguel.pantalla.PantallaRealizarPedido
import com.example.proyecto_falomir_herrero_miguel.pantalla.PantallaResumenPago
import com.example.proyecto_falomir_herrero_miguel.pantalla.PantallaResumenPedido

// METODO INICIAR PANTALLA ------------------------------------------

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Arranque(
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
    PantallaRealizarPedido(modifier)
}

// PREVIEW ----------------------------------------------------------

@Preview(showBackground = true)
@Composable
fun Preview() {
    AppTheme {
        Arranque()
    }
}