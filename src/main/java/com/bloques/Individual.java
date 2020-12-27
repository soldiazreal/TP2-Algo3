package com.bloques;

import com.acciones.*;
import com.personaje.Personaje;

public class Individual extends Bloque{

    private Accion accion;

    public Individual(String nombre, Accion unaAccion) {
        super(nombre);
        this.accion = unaAccion;
    }

    public Accion getAccion(){
        return this.accion;
    }

    @Override
    public void ejecutarBloque(Personaje unPersonaje){
        this.accion.accionar(unPersonaje);

    }
}
