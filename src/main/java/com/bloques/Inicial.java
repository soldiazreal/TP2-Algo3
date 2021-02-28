package com.bloques;

import com.nodos.Nodo;
import com.nodos.NodoNulo;
import com.personaje.Personaje;

public class Inicial implements Bloque{
    @Override
    public void ejecutarBloque(Personaje unPersonaje){

    }

    @Override
    public void invertirBloque(Personaje unPersonaje){
    }

    @Override
    public Bloque copia(){
        return this;
    }

    @Override
    public Nodo primerNodoListaInterna(){
        return new NodoNulo();
    }
}
