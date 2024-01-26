package com.example.practica02_corrutinas.model

/**
 * Esta clase representa un caso de uso para la operación de bloqueo.
 *
 * @property api una instancia de [Api] que este caso de uso utilizará para realizar la operación de bloqueo.
 */
class LockUseCase (private val api: Api) {


    /**
     * Realiza la operación de bloqueo.
     *
     * Llama a resultadoBloqueoApp() para realizar la operación de bloqueo y devuelve su resultado.
     *
     * @return una cadena que representa el resultado de la operación de bloqueo.
     */

    fun bloqueoApp(): String {
        return api.resultadoBloqueoApp()
    }
}