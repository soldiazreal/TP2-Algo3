package com.bloques;

import com.acciones.*;
import com.personaje.Personaje;

public class Individual implements Bloque{

    protected final String nombre;

    private Accion accion;

    public Individual(String nombre, Accion unaAccion) {
        this.nombre = nombre;
        this.accion = unaAccion;
    }

    public String getNombre(){
        return this.nombre;
    }

    public Accion getAccion(){
        return this.accion;
    }

    @Override
    public void ejecutarBloque(Personaje unPersonaje){
        this.accion.accionar(unPersonaje);
    }
}
