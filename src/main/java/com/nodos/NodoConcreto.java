package com.nodos;

import com.bloques.Bloque;
import com.personaje.Personaje;

public class NodoConcreto implements Nodo {

    Nodo siguiente = new NodoNulo();
    Bloque bloque;

    public NodoConcreto (Bloque bloque){
        this.bloque = bloque;
    }

    @Override
    public void insertarSiguiente(Nodo siguiente) {
        Nodo anteriorSiguiente = this.siguiente;
        this.siguiente = siguiente;
        siguiente.ultimoSiguiente().asignarSiguiente(anteriorSiguiente);
    }

    @Override
    public void asignarSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public void ejecutar(Personaje personaje) {
        bloque.ejecutarBloque(personaje);
    }

    @Override
    public void invertir(Personaje personaje) {
        bloque.invertirBloque(personaje);
    }

    @Override
    public Nodo ultimoSiguiente() {
        if (siguiente.esUltimo())
            return this;
        return ultimoSiguiente();
    }

    @Override
    public boolean esUltimo() {
        return false;
    }
}
