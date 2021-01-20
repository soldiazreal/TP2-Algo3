package com.tablero;

import com.bloques.Bloque;
import com.personaje.Personaje;

import java.util.LinkedList;

public class SeccionAlgoritmo{

    private final LinkedList<Bloque> bloquesParaEjecucion;

    public SeccionAlgoritmo(){
        this.bloquesParaEjecucion = new LinkedList<>();
    }

    public void agregarBloqueEnPosicion(Bloque unBloque, Integer unIndice){
        this.bloquesParaEjecucion.add(unIndice,unBloque);
    }

    public void ejecutar(Personaje unPersonaje){

        for (Bloque bloque_actual : this.bloquesParaEjecucion) {
            bloque_actual.ejecutarBloque(unPersonaje);
        }
    }



}
