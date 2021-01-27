package com.tablero;

import com.bloques.Bloque;
import com.factory.CrearBloqueIndividual;
import com.personaje.Personaje;

import java.util.LinkedList;

public class SeccionAlgoritmo{

    private final LinkedList<Bloque> bloquesParaEjecucion;

    public SeccionAlgoritmo(){
        this.bloquesParaEjecucion = new LinkedList<>();
    }

    public void agregarBloqueEnPosicion(CrearBloqueIndividual bloque, int unIndice){
        Bloque bloqueAAgregar = bloque.generarIndividual();
        this.bloquesParaEjecucion.add(unIndice, bloqueAAgregar);
    }

    public void ejecutar(Personaje unPersonaje){
        for (Bloque bloque_actual : this.bloquesParaEjecucion) {
            bloque_actual.ejecutarBloque(unPersonaje);
        }
    }

    //Para que recibe un nombre? Solo necesito el indice para saber cual borrar.
    public void removerBloqueDePosicion(String unNombre, int unIndice){
        this.bloquesParaEjecucion.remove(unIndice);
    }



}
