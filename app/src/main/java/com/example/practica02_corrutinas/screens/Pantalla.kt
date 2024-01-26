package com.example.practica02_corrutinas.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * Función composable que representa la pantalla principal.
 *
 * @param viewModel El ViewModel responsable de gestionar la lógica de la aplicación.
 */
@Composable
fun PantallaInicio(
    viewModel: PantallaViewModel
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            if (!viewModel.isLoading){
                Button(
                    onClick = { viewModel.cambiaColor() },
                    colors = ButtonDefaults.buttonColors(containerColor = viewModel.color)
                ) {
                    Text("Cambiar color")
                }

                Text(viewModel.resultState)

                Button(onClick = { viewModel.callApi() }) {
                    Text("Llamar API")
                }
            } else {
                CircularProgressIndicator()
            }

        }
    }
}

