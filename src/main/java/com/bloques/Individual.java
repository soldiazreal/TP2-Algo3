package com.bloques;

import com.acciones.*;
import com.excepciones.AccionANullException;
import com.nodos.Nodo;
import com.nodos.NodoNulo;
import com.personaje.Personaje;

public class Individual implements Bloque{

    private Accion accion;

    public Individual(Accion unaAccion) {
        if (unaAccion == null)
            throw new AccionANullException("No se puede crear Individual con Accion a null");
        this.accion = unaAccion;
    }

    @Override
    public void ejecutarBloque(Personaje unPersonaje){
        this.accion.accionar(unPersonaje);
    }

    @Override
    public void invertirBloque(Personaje unPersonaje){
        this.accion.invertir(unPersonaje);
    }

    @Override
    public Bloque copia(){
        return new Individual(this.accion);
    }

    @Override
    public Nodo primerNodoListaInterna(){
        return new NodoNulo();
    }
}
