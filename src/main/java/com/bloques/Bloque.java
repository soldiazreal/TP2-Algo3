package com.bloques;

import com.acciones.*;
import com.personaje.*;

public abstract class Bloque {
    public final String nombre;
    protected final Accion accion;

    protected Bloque(String nombre, Accion unaAccion) {
        this.nombre = nombre;
        this.accion = unaAccion;
    }

    public Accion getAccion(){
        return this.accion;
    }

    public abstract void ejecutarBloque(Personaje unPersonaje);
}
