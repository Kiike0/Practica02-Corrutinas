package com.example.practica02_corrutinas.screens


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.practica02_corrutinas.domain.LockUseCase

/**
 * Esta clase representa un ViewModel para la pantalla principal de la aplicación.
 *
 * @property lockUseCase una instancia de la clase LockUseCase que se usa para realizar las operaciones.
 */
class PantallaViewModel (private val lockUseCase: LockUseCase) : ViewModel() {

    var resultState by mutableStateOf("")
    var color by mutableStateOf(Color.Red)

    /**
     * Llama a la API a través del caso de uso que le pasamos en el main y
     * actualiza el resuldato de resultState
     */
    fun llamarApi() {
        resultState = lockUseCase.bloqueoApp()
    }

    /**
     * Función que cambia el color de la variable color para cuando pulsemos el botón
     */
    fun cambiaColor() {
        color = if (color == Color.Red) Color.Blue else Color.Red
    }
}