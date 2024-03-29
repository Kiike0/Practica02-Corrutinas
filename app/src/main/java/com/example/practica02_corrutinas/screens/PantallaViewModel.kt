package com.example.practica02_corrutinas.screens


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

/**
 * Esta clase representa un ViewModel para la pantalla principal de la aplicación.
 *
 */
class PantallaViewModel : ViewModel() {

    var resultState by mutableStateOf("")
    var color by mutableStateOf(Color.Red)
    private var count by mutableIntStateOf(0)

    /**
     * Llama a la API a través del caso de uso que le pasamos en el main y
     * actualiza el resuldato de resultState
     */
    fun llamarApi() {
        resultState = bloqueoApp()
    }

    /**
     * Esta función bloquea el hilo actual durante 5 segundos para simular una operación de larga duración,
     * luego devuelve una cadena que incluye el número de veces que se ha llamado a esta función.
     *
     * @return una cadena que representa la respuesta de la API.
     */
    private fun bloqueoApp(): String {
        Thread.sleep(5000)
        count++
        return "Respuesta de la API $count"
    }

    /**
     * Función que cambia el color de la variable color para cuando pulsemos el botón
     */
    fun cambiaColor() {
        color = if (color == Color.Red) Color.Blue else Color.Red
    }
}