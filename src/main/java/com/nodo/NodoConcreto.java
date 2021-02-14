package com.nodo;

import com.bloques.Bloque;
import com.personaje.Personaje;

public class NodoConcreto extends Nodo{

    public void ejecutar(Personaje personaje){
        bloque.ejecutarBloque(personaje);
        siguiente.ejecutar(personaje);
    }

    public void ejecutarInvertido (Personaje personaje){
        bloque.invertirBloque(personaje);
        siguiente.ejecutarInvertido(personaje);
    }

    public void insertarSiguiente(Nodo nodo){
        Nodo siguienteAnterior = this.siguiente;
        siguiente = nodo;
        this.ultimoSiguiente().cambiarSiguiente(siguienteAnterior);
    }

    public void cambiarSiguiente(Nodo nodo){
        this.siguiente = nodo;
    }

    public Nodo ultimoSiguiente(){
        if (siguiente.esNulo()){
            return this;
        }
        return siguiente.ultimoSiguiente();
    }

    public boolean esNulo(){
        return false;
    }
}
