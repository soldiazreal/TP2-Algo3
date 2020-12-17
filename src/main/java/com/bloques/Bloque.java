package com.bloques;

import com.acciones.*;
import com.personaje.*;

public abstract class Bloque {
    protected final String nombre;
    protected final Accion accion;

    protected Bloque(String nombre, Accion unaAccion) {
        this.nombre = nombre;
        this.accion = unaAccion;
    }

    public Accion getAccion(){
        return this.accion;
    }

    public String getNombre(){
        return this.nombre;
    }

    public abstract void ejecutarBloque(Personaje unPersonaje);
}
