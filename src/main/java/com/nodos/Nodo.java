package com.nodos;

import com.personaje.Personaje;


public interface Nodo {

    void insertarSiguiente(Nodo siguiente);

    void asignarSiguiente(Nodo siguiente);

    void ejecutar(Personaje personaje);

    void invertir(Personaje personaje);

    Nodo conseguirSiguiente();

    Nodo ultimoSiguiente();

    Nodo copiar();

    boolean esUltimo();

    Nodo primerNodoListaInternaDeBloque();
}
