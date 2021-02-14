package com.nodo;

import com.personaje.Personaje;

public class NodoNulo extends Nodo {

    public void ejecutar(Personaje personaje){}

    public void ejecutarInvertido (Personaje personaje){}

    public void insertarSiguiente(Nodo nodo){}

    public void cambiarSiguiente(Nodo nodo){}

    public Nodo ultimoSiguiente(){
        return null;
    }

    public boolean esNulo (){
        return true;
    }
}
