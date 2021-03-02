package com.tablero;

import com.bloques.Bloque;
import com.bloques.Inicial;
import com.personaje.Personaje;
import com.nodos.*;


public class SeccionAlgoritmo{

    private final Nodo nodos;

    public SeccionAlgoritmo(){
        this.nodos = new NodoConcreto(new Inicial());
    }

    public Nodo getNodo(){
        return this.nodos;
    }

    public void agregarBloqueDespuesDe(Bloque bloqueInsertar, Nodo nodoPadre){
            nodoPadre.insertarSiguiente(new NodoConcreto(bloqueInsertar));
    }

    public void ejecutar(Personaje unPersonaje){
        nodos.ejecutar(unPersonaje);
    }

    public void removerSiguienteBloque(Nodo nodoPadre){
        Nodo nodoHijo = nodoPadre.conseguirSiguiente();
        Nodo nuevoHijo = nodoHijo.conseguirSiguiente();
        nodoPadre.asignarSiguiente(nuevoHijo);
    }
}
