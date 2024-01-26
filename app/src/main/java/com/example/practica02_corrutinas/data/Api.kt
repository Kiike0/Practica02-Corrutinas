package com.example.practica02_corrutinas.data

/**
 * Esta clase representa una API ficticia que simula una operación de larga duración.
 */
class Api {

    private var count = 0

    /**
     * Esta función bloquea el hilo actual durante 5 segundos para simular una operación de larga duración,
     * luego devuelve una cadena que incluye el número de veces que se ha llamado a esta función.
     *
     * @return una cadena que representa la respuesta de la API.
     */
    fun resultadoBloqueoApp(): String {
        Thread.sleep(5000)
        count++
        return "Respuesta de la API $count"
    }
}