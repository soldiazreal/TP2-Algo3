package com.nodos;

import com.bloques.Bloque;
import com.bloques.Inicial;
import com.personaje.Personaje;

//nodonulo
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
}

