package com.example.practica02_corrutinas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.practica02_corrutinas.screens.PantallaInicio
import com.example.practica02_corrutinas.screens.PantallaViewModel
import com.example.practica02_corrutinas.ui.theme.Practica02_CorrutinasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practica02_CorrutinasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        PantallaInicio(viewModel = PantallaViewModel())
                }
            }
        }
    }
}
