package com.bloques;

import com.acciones.*;
import com.excepciones.AccionANullException;
import com.personaje.Personaje;

public class Individual implements Bloque{

    private String nombre;

    private Accion accion;

    public Individual(String nombre, Accion unaAccion) {
        if (unaAccion == null)
            throw new AccionANullException("No se puede crear Individual con Accion a null");
        this.nombre = nombre;
        this.accion = unaAccion;
    }

    public String getNombre(){
        return this.nombre;
    }

    @Override
    public void ejecutarBloque(Personaje unPersonaje){
        this.accion.accionar(unPersonaje);
    }

    @Override
    public void invertirBloque(Personaje unPersonaje){
        this.accion.invertir(unPersonaje);
    }
}
