package com.nodo;

import com.bloques.Bloque;
import com.personaje.Personaje;

public abstract class Nodo {

    protected Bloque bloque;
    protected Nodo siguiente;

    abstract void ejecutar(Personaje personaje);

    abstract void ejecutarInvertido (Personaje personaje);

    abstract void insertarSiguiente(Nodo nodo);

    abstract void cambiarSiguiente(Nodo nodo);

    abstract Nodo ultimoSiguiente();

    abstract boolean esNulo ();
}
