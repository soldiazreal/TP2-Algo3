package com.nodos;

import com.personaje.Personaje;

public class NodoNulo implements Nodo {



    @Override
    public Nodo copiar(){
        NodoNulo nuevoNodo = new NodoNulo();
        return nuevoNodo;
    }

    @Override
    public Nodo conseguirSiguiente(){return this;}

    @Override
    public void insertarSiguiente(Nodo siguiente) {

    }

    @Override
    public void asignarSiguiente(Nodo siguiente) {

    }

    @Override
    public void ejecutar(Personaje personaje) {

    }

    @Override
    public void invertir(Personaje personaje) {

    }

    @Override
    public Nodo ultimoSiguiente() {
        return this;
    }

    @Override
    public boolean esUltimo() {
        return true;
    }

    @Override
    public Nodo primerNodoListaInternaDeBloque(){
        return new NodoNulo();
    }
}

