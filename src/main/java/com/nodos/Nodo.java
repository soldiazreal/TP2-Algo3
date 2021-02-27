package com.nodos;

import com.personaje.Personaje;


//algo
public interface Nodo {

    void insertarSiguiente(Nodo siguiente);

    void asignarSiguiente(Nodo siguiente);

    void ejecutar(Personaje personaje);

    void invertir(Personaje personaje);

    Nodo ultimoSiguiente();

    boolean esUltimo();
}
