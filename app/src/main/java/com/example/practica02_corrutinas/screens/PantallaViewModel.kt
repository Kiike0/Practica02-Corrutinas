package com.example.practica02_corrutinas.screens


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Esta clase representa un ViewModel para la pantalla principal de la aplicación.
 *
 */
class PantallaViewModel : ViewModel() {

    var resultState by mutableStateOf("")
    var color by mutableStateOf(Color.Red)
    var isLoading by mutableStateOf(false)
    private var count by mutableIntStateOf(0)

    /**
     * Llama a la API a través del caso de uso que le pasamos en el main y
     * actualiza el resuldato de resultState
     */
    fun callApi() {
        fetchData()
    }

    /**
     * Esta función bloquea el hilo actual durante 5 segundos para simular una operación de larga duración,
     * luego devuelve una cadena que incluye el número de veces que se ha llamado a esta función.
     *
     * @return una cadena que representa la respuesta de la API.
     */
    /* No la vamos a utilizar como dice el ejercicio:
    private fun bloqueoApp(): String {
        Thread.sleep(5000)
        count++
        return "Respuesta de la API $count"
    }
    */
    /**
     * Función que nos permite crear una corrutina desde un ViewModel
     */
    private fun fetchData() {
        viewModelScope.launch {
            try {
                isLoading = true
                llamarApi()
            } catch (e: Exception) {
                println("Error ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }
    /**
     * Solo funcionan dentro de una corrutina u otra función suspendida
     */
    private suspend fun llamarApi() {
        val result = withContext(Dispatchers.IO) {
            count++
            delay(5000)
            "Respuesta de la API $count"
        }
        resultState = result
    }

    /**
     * Función que cambia el color de la variable color para cuando pulsemos el botón
     */
    fun cambiaColor() {
        color = if (color == Color.Red) Color.Blue else Color.Red
    }
}